import React, { useState } from "react";
import { useLocation } from "react-router-dom";
import API from "../../api/API";

const SignUpPage = () => {
  
  const [inputs, setInputs] = useState({
    nickName: '',
    greetings: '',
    github: '',
  });
  const { nickName, greetings, github } = inputs;
  const locations = useLocation().state;
  const { email, pw, userId } = locations;

  const handleOnChange = (e) => {
    const { value, name } = e.target;
    setInputs({
      ...inputs,
      [name]: value
    });
  };

  const signUp = () => {
    API.post("api/user", {
      email: email,
      password: pw,
      userId: userId,
      nickName: nickName,
      github: github,
      greeting: greetings,
    })
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      })
  }

  return (
    <>
      <h1>회원가입 페이지!</h1>

      닉네임<input name="nickName" onChange={handleOnChange} value={nickName}/>
      소개말<input name="greetings" onChange={handleOnChange} value={greetings}/>
      Github<input name="github" onChange={handleOnChange} value={github}/>
      <button onClick={signUp}>회원가입</button>
    </>
  )
}

export default SignUpPage;