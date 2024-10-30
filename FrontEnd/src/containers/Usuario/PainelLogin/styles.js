import styled from "styled-components";
import { Form } from 'react-bootstrap';

export const Container = styled.div `
    height: 100%;
    width: 100%;
    display: flex;
    flex-direction: column;
    background-color: white;
    justify-content:initial;
    align-items: center;
    text-align: center;
`

export const Title = styled.label `
    display: flex;
    flex-direction: row;
    font-size: 50px;
    text-align: center;
    justify-content: center;
    flex-direction: center;
    align-items: center;
    height: 10%;
    padding-top:20px;
`

export const Content = styled.form `
    margin-top: 5%;
    height: 70%;
    width: 60%;
    display: flex;
    flex-direction: column;
    background-color: rgb(240,240,240);
    border-radius: 50px;
    justify-content: center;
    align-items: center;
    gap: 10px;
`

export const ContentTitle = styled.form `
    height: 30%;
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;
`

export const ContentInput = styled.form `
    height: 15%;
    width: 100%;
    display: flex;
    flex-direction:column;
    align-items: center;
    text-align: center;
    justify-content:initial;
`

export const Text = styled.label `
    display: flex;
    height: 30px;
    width: 70%;
    border-radius: 10px;
    padding-left: 5px;
`

export const Input = styled.input`
    height: 40px;
    width: 70%;
    border-radius: 10px;
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.5);
    padding-left: 10px;
    outline: none;
    border: 1px transparent;
    &:focus{
        border-bottom: 2px solid black;
    }
`
export const Button = styled.button`
    font-size: 20px;
    color: #333;
    height: 8%;
    width: 40%;
    margin-bottom: 50px;
    border-radius: 20px;
    background-color:white;
    margin-top: 30px;

    &:hover{
        background-color:black;
        color:white;
    }
`;