<div align="center">
	![ssapilogue](https://user-images.githubusercontent.com/78924207/170977365-7812bb38-666c-4876-b8a4-7e8ee37798d0.png)
</div>

> **SSAFY + Epilogue**
>
> SSAFY에서 프로젝트를 완성하고 난 뒤, 어떻게 홍보하고 피드백을 받으시나요?
>
> 싸피인들을 위한 프로젝트 공유 플랫폼, 싸필로그에 여러분을 초대합니다.
>
> 편하게 프로젝트를 홍보하고 효과적으로 피드백을 받아보세요!

<br/>

##  프로젝트 목차

1. [팀소개](#1.-팀소개)
2. [프로젝트 소개](#2.-프로젝트-소개)
   - [기술 스택](#🛠-기술-스택)
   - [아키텍처](#💻-아키텍처)
   - [ERD](#📊-ERD)
   - [UI 프로토타입](#🎨-UI-프로토타입)
3. [프로젝트 파일 구조](#3.-프로젝트-파일-구조)
	- [Backend](#Backend)
	- [Frontend](#Frontend)
4. [프로젝트 산출물](#4.-프로젝트-산출물)
5. [프로젝트 결과](#5.-프로젝트-결과)

<br/>

## 1. 팀소개

🐝 프로폴리스

> **Pro**ject + **Police** = 프로젝트를 지키는 사람들

| <a href="https://github.com/hyunse0"><img src="https://avatars.githubusercontent.com/u/78924207?v=4" alt="" style="zoom:33%;" /></a> | <a href="https://github.com/eunseo130"><img src="https://avatars.githubusercontent.com/u/84255977?v=4" alt="" style="zoom:33%;" /></a> | <a href="https://github.com/kimhyeongjun95"><img src="https://avatars.githubusercontent.com/u/86656921?v=4" alt="" style="zoom:33%;" /></a> | <a href="https://github.com/DongKyunJung"><img src="https://avatars.githubusercontent.com/u/87457171?v=4" alt="" style="zoom:33%;" /></a> | <a href="https://github.com/khyunchoi"><img src="https://avatars.githubusercontent.com/u/77478732?v=4" alt="" style="zoom:33%;" /></a> |
| :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
|                            하현서                            |                            김은서                            |                            김형준                            |                            정동균                            |                            최강현                            |
|                        팀장, Backend                         |                        Backend, Deploy                        |                           Frontend                           |                           Frontend                           |                        Backend, Deploy                        |

<br/>

## 2. 프로젝트 소개

🗓 일정 : 2022.04.12 ~ 2022.05.20 (총 6주)

<br/>

### 🛠 기술 스택
| 역할         | Tool                                                         |
| ------------ | ------------------------------------------------------------ |
| 이슈관리     | Jira                                                         |
| 형상관리     | Gitlab                                                       |
| 커뮤니케이션 | Mattermost, Notion                                           |
| 디자인       | Figma                                                        |
| 개발 환경    | - OS : Windows 10<br />- DB : MySQL 8.0.29, Mongo DB 4.4.13<br />- Server : AWS EC2, Ubuntu 20.04 LTS, Docker 20.10.14, Nginx 1.18.0, Jenkins 2.332.2 |
| Backend      | - Java openjdk 11.0.15<br />- SpringBoot 2.6.6               |
| Frontend     | - React 17.0.1<br/>- Sass 1.50.1<br/> - Node.js 16.13.1      |
| IDE          | - Intellij 21.3.2<br />- Visual Studio Code 1.67             |

<br/>

### 💻 아키텍처

<img src="https://user-images.githubusercontent.com/78924207/169424547-e18f449b-7ea9-4997-93df-2b5e45c51337.png" width="700" />

<br/>

### 📊 ERD

<img src="https://user-images.githubusercontent.com/78924207/169424950-932ce0cc-d40a-4885-9de2-0b53540474c9.png" width="1000" />

<br/>

### 🎨 UI 프로토타입

<img src="https://user-images.githubusercontent.com/78924207/169427127-cba33d7c-38f4-41cd-93ad-0979c7607f08.png" width="1000" />
<img src="https://user-images.githubusercontent.com/78924207/169427152-1d67f339-785c-4ec5-9044-5cb3fe463955.png" width="1000" />
<img src="https://user-images.githubusercontent.com/78924207/169427202-50de38ff-8a2e-4352-8b2b-49ccc830fbe5.png" />
<img src="https://user-images.githubusercontent.com/78924207/169427196-c00f223b-e293-447f-8ff2-54e46942d33e.png" width="1000" />

<br/>

## 3. 프로젝트 파일 구조

### Backend

```markdown
java/com/ssafy/ssapilogue
├── api
│	├── config
│	│
│	├── controller
│	│
│	├── dto
│	│	├── request
│	│	└── response
│	│
│	├── exception
│	│
│	├── service
│	│
│	└── util
│
└── core
    ├── config
    │
    ├── queryrepository
    │
    └── repository
```

<br/>

### Frontend

```markdown
frontend
└── src
	├── api
	│
	├── assets
	│
	├── components
	│	├── Footer
	│	├── Input
	│	└── Navbar
	│
	├── pages
	│
	├── utils
	│	└── store
	│
	├── App.jsx
	├── App.scss
	├── index.css
	└── index.jsx
```

<br/>

## 4. 프로젝트 산출물

- [Ssapilogue Notion 바로가기](https://satisfying-starfish-993.notion.site/dd785428616e47d69512de7cf90003c4)
- [프로젝트 계획서](https://www.notion.so/b4f5ea786b76435a816b9adf03546a94)
- [요구사항 명세서](https://www.notion.so/71bd6686764e49fe901976b3ea7d88f0?v=abbf74a7c33a4f24ae685412af26f6ac)
- [API 명세서](https://www.notion.so/fa7103c8651c4d4c8af473a954487430?v=e4401d7ba0ca4de2a0867522214d4469)

- [최종 발표 자료](https://www.notion.so/d6f8b16a60204bb881b5be76d4d5a1aa)
- [프로젝트 서비스 UCC](https://www.notion.so/d6f8b16a60204bb881b5be76d4d5a1aa)

<br/>

## 5. 프로젝트 결과

🥈삼성 청년 SW 아카데미 2학기 자율 프로젝트 광주 1반 2등🥈
