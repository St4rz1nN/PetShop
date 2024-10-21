import { Container, Content, ContentTitle, ContentInput, Title, Text, Button, Input } from './styles.js'
import { useState, useEffect } from 'react';
import Modal from '../../../components/Modal/index.jsx';
import { Form } from 'react-bootstrap';
import api from '../../../services/api.js'
import { FaTrash } from 'react-icons/fa';
import Header from '../../../components/Header/index.jsx'

function PainelLogin(){
    

    const [modoEdicao, setModoEdicao] = useState(false);

    const [modalVisivel, setModalVisivel] = useState(false);
    const [tipoModal, setTipoModal] = useState("Carregando");
    const [mensagemModal, setMensagemModal] = useState("");
    const [textTamanho, setTextTamanho] = useState(40);
    const [modalHeight, setModalHeight] = useState(300);
    const [modalWidth, setModalWidth] = useState(600);

    const handleModal = (Tipo, Mensagem, Height, Width, TextTamanho) => {
        setTipoModal(Tipo);
        setMensagemModal(Mensagem);
        setModalVisivel(true);
        setModalHeight(Height)
        setModalWidth(Width)
        setTextTamanho(TextTamanho)
      }
    const closeModal = () => {
        setModalVisivel(false);
    };


    //Variaveis
    const [formData, setFormData] = useState({
        email: '',
        senha: '',
    });

    const handleChange = (event) => {
        const {name, value} = event.target;
        setFormData({
            ...formData,
            [name]: value
        }
        )
    }

    const realizarLoginAsync = async () => {
        try{
            const formDataApi = new FormData();

            formDataApi.append('email', formData.nome);
            formDataApi.append('senha', formData.tipo);
            
            const response = await api.post('usuario',formDataApi, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            });
            handleModal("Alerta", `Sucesso ao realizar o Login!:`,300,600,20)
        }catch(error){
            handleModal("Alerta", `Falha ao realizar o login: + ${error.message}`,300,600,20)
        }
    }

    const realizarLogin = (event) => {
        event.preventDefault();
        const form = event.target;
        if (form.checkValidity()) {
           realizarLoginAsync();
        } else {
            form.reportValidity();
        }
    };
    

    return (
        <Container>
            <Header
                titleName="Pet Shop"
                administrador={false}
                subLinks={false}
            />
            <Modal
            Height={modalHeight}
            Width={modalWidth}
            Tipo={tipoModal}
            Mensagem={mensagemModal}
            Visivel={modalVisivel}
            TextTamanho={textTamanho}
            OnClick={closeModal}
            />
            <Content onSubmit={realizarLogin}>
                <ContentTitle>
                    <Title>
                        Painel de Login
                    </Title>
                </ContentTitle>
                <ContentInput>
                    <Text>
                        Email
                    </Text>
                    <Input
                        type="text"
                        placeholder="Email"
                        value={formData.email}
                        name="email"
                        onChange={handleChange}
                        required
                    />
                </ContentInput>
                <ContentInput>
                    <Text>
                        Senha
                    </Text>
                    <Input
                        type="text"
                        placeholder="Senha"
                        value={formData.senha}
                        name="senha"
                        onChange={handleChange}
                        required
                    />
                </ContentInput>
                <Button type="submit">
                    Login
                </Button>
            </Content>
        </Container>
    )
}

export default PainelLogin;