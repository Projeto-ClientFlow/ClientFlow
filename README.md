<div align='center', id='topo'/>

# Projeto ClientFlow
## CRM - Sistema de Gestão de Clientes

![Banner do Projeto ClientFlow](https://github.com/Projeto-ClientFlow/ClientFlow/blob/4c406ac1deaa08fe3cdabae57960278b204de6e6/src/img/ClientFlow_Banner.png)

</div>

O projeto **ClientFlow** é uma aplicação backend desenvolvida em Java com o **Spring Framework**, contendo integração a um banco de dados SQL. Seu principal objetivo é oferecer uma API CRUD eficiente para a gestão de clientes, categorias e produtos, garantindo um fluxo organizado e estruturado de informações.

******

<div align='center'/>

  ![Java](https://a11ybadges.com/badge?logo=java)
  ![Spring](https://a11ybadges.com/badge?logo=spring)
  ![MySQL](https://a11ybadges.com/badge?logo=mysql)
  ![Insomnia](https://a11ybadges.com/badge?logo=insomnia)

</div>

******

## 📖 Tabela de Conteúdo
- [💡 Conhecimentos Mobilizados](#conhecimentosMobilizados)
- [🏗️ Estrutura do Projeto](#estruturaDoProjeto)
- [📂 Código Desenvolvido](#codigoDesenvolvido)
- [🛠️ Tecnologias Utilizadas](#tecnologiasUtilizadas)
- [🤝 Desenvolvedoras do Projeto](#devas)

---

<div id='conhecimentosMobilizados'/> 

## 💡 Conhecimentos Mobilizados

- **Spring Framework:** Uso do Spring Boot para a construção de APIs RESTful, seguindo boas práticas de desenvolvimento.
- **JPA e Hibernate:** Mapeamento objeto-relacional para integração com o banco de dados MySQL, garantindo uma persistência eficiente.
- **Padrões de Projeto:** Implementação da arquitetura em camadas (Model, Repository, Controller) para uma melhor organização do código.
- **Banco de Dados:** Configuração e gerenciamento do banco de dados MySQL, utilizando Spring Data JPA para persistência dos dados.
- **RESTful API:** Desenvolvimento de endpoints para manipulação das entidades do sistema, permitindo operações CRUD para usuários, categorias e produtos.

<div id='estruturaDoProjeto'/>

## 🏗️ Estrutura do Projeto

```
clientflow/
├── controller/
│   ├── UsuarioController.java
│   ├── CategoriaController.java
│   └── ProdutoController.java
├── model/
│   ├── Usuario.java
│   ├── Categoria.java
│   └── Produto.java
├── repository/
│   ├── UsuarioRepository.java
│   ├── CategoriaRepository.java
│   └── ProdutoRepository.java
├── resources/
│   └── application.properties
└── ClientFlowApplication.java
```

<div id='codigoDesenvolvido'/> 

## 📂 Código Desenvolvido

Para melhor visualização, aqui estão os principais componentes do sistema:

- `UsuarioController` / `CategoriaController` / `ProdutoController`: Controladores responsáveis pela manipulação das respectivas entidades, implementando métodos como getAll(), getById(), create(), update() e delete().
- `Usuario` / `Categoria` / `Produto`: Modelos que representam as entidades do sistema, incluindo atributos essenciais para o funcionamento da aplicação.
- `UsuarioRepository` / `CategoriaRepository` / `ProdutoRepository`: Interfaces que estendem JpaRepository, permitindo a comunicação eficiente com o banco de dados MySQL.
application.properties: Arquivo de configuração que define a conexão com o banco de dados, especificando credenciais e propriedades do Spring.
- `ClientFlowApplication`: Classe principal que inicializa a aplicação Spring Boot.

---

<div id='tecnologiasUtilizadas'/> 

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Java  
- **Framework**: Spring Boot  
- **Banco de Dados**: MySQL  
- **JPA/Hibernate**: Para persistência de dados  
- **IDE utilizada**: Spring Tools Suite (STS)
- **Ferramenta de Testes**: Insomnia

---

<div id='devas'/> 
  
## 🤝 Desenvolvedoras do Projeto

Este projeto foi possível graças às contribuições das seguintes desenvolvedoras:

<div align="center">
  <table>
    <tr>
      <td align="center">
        <a href="https://www.linkedin.com/in/larissa-mata-a32a5a104/" title="Linkedin da Larissa Mata">
          <img src="https://media.licdn.com/dms/image/v2/D4D03AQH8ZGW05SThzA/profile-displayphoto-shrink_400_400/profile-displayphoto-shrink_400_400/0/1698075416577?e=1747267200&v=beta&t=MZQra9MZhtWWZqrZx6Re7loE6-KZIhHj9kj5Rbxe_Ds" width="100px;" alt="Foto da Larissa Mata"/><br>
          <sub>
            <b>Larissa Mata</b>
          </sub>
        </a>
      </td>
      <td align="center">
        <a href="https://www.linkedin.com/in/elianempontes/" title="Linkedin da Eliane Medeiros">
          <img src="https://media.licdn.com/dms/image/v2/D4D03AQGppzwuto4Skw/profile-displayphoto-shrink_400_400/B4DZOzMU5sHUAg-/0/1733878173890?e=1747267200&v=beta&t=dYk2XBvZ6Be-J99J4sp9kljf2TF3ZZ5YZ8lEu72U7oA" width="100px;" alt="Foto da Eliane Medeiros"/><br>
          <sub>
            <b>Eliane Medeiros</b>
          </sub>
        </a>
      </td>
      <td align="center">
        <a href="https://github.com/willaevangelista" title="GitHub da Willa Evangelista">
          <img src="https://avatars.githubusercontent.com/u/84138876?v=4" width="100px;" alt="Foto da Willa Evangelista"/><br>
          <sub>
            <b>Willa Evangelista</b>
          </sub>
        </a>
      </td>
    </tr>
  </table>
  <table>
    <tr>
      <td align="center">
        <a href="https://www.linkedin.com/in/larissa-alves-s/" title="Linkedin da Larissa Alves">
          <img src="https://media.licdn.com/dms/image/v2/D4D03AQFZaBaC-aUVow/profile-displayphoto-shrink_400_400/B4DZSqh72uHYAg-/0/1738027811288?e=1747267200&v=beta&t=6DM_y3QMq47Kb_qSkOcxjFlPsaBcqwZ_0JxLYxL1Bm8" width="100px;" alt="Foto da Larissa Alves"/><br>
          <sub>
            <b>Larissa Alves</b>
          </sub>
        </a>
      </td>
      <td align="center">
        <a href="https://github.com/MariPimentelCarmo" title="GitHub da Mariana Carmo">
          <img src="https://avatars.githubusercontent.com/u/99743029?v=4" width="100px;" alt="Foto da Mariana Carmo"/><br>
          <sub>
            <b>Mariana Carmo</b>
          </sub>
        </a>
    </tr>
  </table>
</div>

<div align='right'>
  
[Voltar ao topo ⬆️](#topo)
