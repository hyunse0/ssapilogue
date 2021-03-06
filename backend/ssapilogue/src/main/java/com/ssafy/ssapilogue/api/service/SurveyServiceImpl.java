package com.ssafy.ssapilogue.api.service;

import com.ssafy.ssapilogue.api.dto.request.CreateSurveyReqDto;
import com.ssafy.ssapilogue.api.dto.request.DeleteSurveyReqDto;
import com.ssafy.ssapilogue.api.dto.response.FindDefaultSurveyResDto;
import com.ssafy.ssapilogue.api.dto.response.FindEditVerSurveyResDto;
import com.ssafy.ssapilogue.api.dto.response.FindSurveyOptionResDto;
import com.ssafy.ssapilogue.api.dto.response.FindSurveyResDto;
import com.ssafy.ssapilogue.api.exception.CustomException;
import com.ssafy.ssapilogue.api.exception.ErrorCode;
import com.ssafy.ssapilogue.core.domain.Review;
import com.ssafy.ssapilogue.core.domain.Survey;
import com.ssafy.ssapilogue.core.domain.SurveyOption;
import com.ssafy.ssapilogue.core.domain.SurveyType;
import com.ssafy.ssapilogue.core.repository.ReviewRepository;
import com.ssafy.ssapilogue.core.repository.SurveyOptionRepository;
import com.ssafy.ssapilogue.core.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;

    private final SurveyOptionRepository surveyOptionRepository;

    private final ReviewRepository reviewRepository;

    private final SurveyOptionService surveyOptionService;

    @Override
    public List<FindSurveyResDto> findSurveys(Long projectId) {
        List<FindSurveyResDto> surveyList = new ArrayList<>();

        List<Survey> surveys = surveyRepository.findAllByProjectId(projectId);
        for (Survey survey : surveys) {
            List<FindSurveyOptionResDto> surveyOptionList = new ArrayList<>();

            List<SurveyOption> surveyOptions = surveyOptionRepository.findAllBySurveyId(survey.getId());
            for (SurveyOption surveyOption : surveyOptions) {
                surveyOptionList.add(new FindSurveyOptionResDto(surveyOption));
            }

            surveyList.add(new FindSurveyResDto(survey, surveyOptionList, ""));
        }

        return surveyList;
    }

    @Override
    public List<String> createSurvey(Long projectId, List<CreateSurveyReqDto> createSurveyReqDtos) {
        List<String> surveyIds = new ArrayList<>();

        for (CreateSurveyReqDto createSurveyReqDto : createSurveyReqDtos) {
            if (createSurveyReqDto.getSurveyId() == null) {
                Survey survey = Survey.builder()
                        .projectId(projectId)
                        .title(createSurveyReqDto.getTitle())
                        .surveyType(SurveyType.valueOf(createSurveyReqDto.getSurveyType()))
                        .build();

                Survey saveSurvey = surveyRepository.save(survey);

                // ???????????? ??????, SurveyOption ??????
                if (saveSurvey.getSurveyType() == SurveyType.?????????) {
                    List<SurveyOption> surveyOptions = new ArrayList<>();

                    for (String content : createSurveyReqDto.getSurveyOptions()) {
                        if (content != null) {
                            SurveyOption surveyOption = surveyOptionService.createSurveyOption(saveSurvey.getId(), content);
                            surveyOptions.add(surveyOption);
                        }
                    }

                    saveSurvey.addSurveyOptions(surveyOptions);
                    surveyRepository.save(saveSurvey);
                }
                surveyIds.add(saveSurvey.getId());
            }
        }
        return surveyIds;
    }

    @Override
    public void deleteSurvey(DeleteSurveyReqDto deleteSurveyReqDto) {
        for (String surveyId : deleteSurveyReqDto.getSurveyIds()) {
            // ???????????? ??????, SurveyOption ??????
            Survey survey = surveyRepository.findById(surveyId)
                    .orElseThrow(() -> new CustomException(ErrorCode.SURVEY_NOT_FOUND));

            if (survey.getSurveyType() == SurveyType.?????????) {
                for (SurveyOption surveyOption : survey.getSurveyOptions()) {
                    surveyOptionService.deleteSurveyOption(surveyOption.getId());
                }
            }

            // ?????? ??????
            List<Review> reviews = reviewRepository.findAllBySurveyOrderByCreatedAtDesc(survey);
            for (Review review : reviews) {
                reviewRepository.deleteById(review.getId());
            }

            surveyRepository.deleteById(surveyId);
        }
    }

    @Override
    public List<FindDefaultSurveyResDto> defaultSurvey(String projectTitle) {
        List<FindDefaultSurveyResDto> defaultSurvey = new ArrayList<>();

        // ?????????
        List<String> option1 = new ArrayList<>();
        option1.add("100%");
        option1.add("80%");
        option1.add("60%");
        option1.add("40%");
        option1.add("20%");
        defaultSurvey.add(new FindDefaultSurveyResDto(projectTitle, "??? ???????????? ?????? ???????????? ???????????????????", "?????????", option1));

        // UI
        List<String> option2 = new ArrayList<>();
        option2.add("?????????");
        option2.add("???????????????");
        option2.add("????????????");
        option2.add("????????? ??????");
        option2.add("?????? ????????? ??????");
        defaultSurvey.add(new FindDefaultSurveyResDto(projectTitle, "??? UI(User Interface)??? ???????????????????", "?????????", option2));

        // ?????? ??????
        defaultSurvey.add(new FindDefaultSurveyResDto(projectTitle, "??? ????????? ???????????? ??? ??????????????? ???????????????????", "?????????", option2));

        // ?????????
        defaultSurvey.add(new FindDefaultSurveyResDto(projectTitle, "??? ???????????? ?????????????????? ?????? ????????? ????????? ????????????????", "?????????", option2));

        // ?????? ??????
        defaultSurvey.add(new FindDefaultSurveyResDto(projectTitle, "??? ?????? ???????????? ????????? ???????????????!", "?????????", null));

        return defaultSurvey;
    }

    @Override
    public List<FindEditVerSurveyResDto> findEditSurveys(Long projectId) {
        List<FindEditVerSurveyResDto> surveyList = new ArrayList<>();

        List<Survey> surveys = surveyRepository.findAllByProjectId(projectId);
        for (Survey survey : surveys) {
            List<String> surveyOptionList = new ArrayList<>();

            List<SurveyOption> surveyOptions = surveyOptionRepository.findAllBySurveyId(survey.getId());
            for (SurveyOption surveyOption : surveyOptions) {
                surveyOptionList.add(surveyOption.getContent());
            }

            surveyList.add(new FindEditVerSurveyResDto(survey, surveyOptionList, ""));
        }

        return surveyList;
    }
}
