import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './styles/global.css'
import { BrowserRouter, createBrowserRouter, RouterProvider } from 'react-router-dom';
import CadastrarProduto from './containers/Administrador/CadastrarProduto'
import PainelAdministrador from './containers/Administrador/PainelAdministrador'
import PainelProdutos from './containers/Administrador/PainelProdutos'
import PainelLogin from './containers/Usuario/PainelLogin/index.jsx'

const router = createBrowserRouter([

  {
    path: "/cadastrarproduto",
    element: <CadastrarProduto />
  },

  {
    path: "/painellogin",
    element: <PainelLogin />
  },

  {
    path: "/",
    element: <PainelProdutos />
  },
  
])

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>,
)
