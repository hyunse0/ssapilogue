import React,{ useState, useEffect } from "react";
import "./style.scss"
import API from "../../api/API";
import store from "../../utils/store"
import Card from "../../components/Card";

const ProfilePage = () => {

  const [i,setI] = useState(2)
  const [bmi, setBmi] = useState(2)
  const [user, setUser] = useState('');
  const [myproject, setMyproject] = useState([])
  const [mybmProject, setMybmProject] = useState([])

  const power = () => {
    setMyproject(user["projects"].slice(0,3*i))
    setI(i+1)
  }

  const bmpower = () => {
    setMybmProject(user["bookmarkList"].slice(0,3*bmi))
    setBmi(bmi+1)
  }
  
  useEffect(() => {
    store.getToken()
    API.get("api/user")
      .then((response) => {
        console.log(response);
        setUser(response.data.user);
        setMyproject(response.data.user["projects"].slice(0,3))
        setMybmProject(response.data.user["bookmarkList"].slice(0,3))
      })
  }, [])

  return (
    <div>
      <div className="profile-div">
        <div className="profile-box">
          <div className="img-div">
            <p> 좋아요 : {user.userLiked}개</p>
            <img className="profile-pic" src={user.image} alt="profilePic" />
          </div>
          <div className="introduce-div">
            <p>이름 : {user.nickname}</p>
            <p>이메일 : {user.email}</p>
            <p>github : {user.github}</p>
            <p>자기소개 : {user.greeting}</p>
          </div>
        </div>
      </div>
      <div className="my-project-div">
        <h2 className="my-post-h">내가 포스팅한 프로젝트</h2>
        <div className="card-div">
          {myproject.map((item, idx) => (
            <div key={idx}>
              <Card
                title={item.title}
                content={item.content}
                category={item.category}
                likeCnt={item.likeCnt}
                viewCnt={item.viewCnt}
                commentCnt={item.commentCnt}
                techStack={item.techStack}
                thumbnail={item.thumbnail}
              />
            </div>
          ))}
        </div>
        {
          myproject.length > 0 && myproject.length === user["projects"].length ?
          
            null
            : <button onClick={power}>더보기</button>
        }
      </div>

      <div className="my-project-div">
        <h2 className= "my-post-h">내가 북마크한 프로젝트</h2>
        <div className="card-div">
          {mybmProject.map((item, idx) => (
            <div key={idx}>
              <Card
                title={item.title}
                content={item.content}
                category={item.category}
                likeCnt={item.likeCnt}
                viewCnt={item.viewCnt}
                commentCnt={item.commentCnt}
                techStack={item.techStack}
                thumbnail={item.thumbnail}
              />
            </div>
          ))}
        </div>
        {
          mybmProject && mybmProject.length === user["bookmarList"]?.length ?
          
            null
            : <button onClick={bmpower}>더보기</button>
        }
      </div>
    </div>
  )
}

export default ProfilePage;