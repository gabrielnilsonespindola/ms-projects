# Sobre este projeto :

● Projeto desenvolvido no curso de Micro Serviços da "DevSuperior".

● Este projeto é uma arquitetura baseada em microserviços(Java com Spring Boot e Spring Cloud) voltada para a área de Recursos Humanos (HR - Human Resources), composta por múltiplos serviços independentes que se comunicam entre si. A solução foi desenvolvida com foco em escalabilidade, segurança, separação de responsabilidades e ambientes bem definidos para testes, desenvolvimento e produção.

# Estrutura dos Microserviços

● A arquitetura é composta pelos seguintes serviços:

● hr-worker: Responsável pelas informações dos trabalhadores (funcionários).

● hr-user: Gerencia os perfis de usuários e os acessos com base em roles e autorizações.

● hr-payroll: Serviço responsável pelo processamento da folha de pagamento, com acesso restrito a usuários com perfil de admin.

# Infraestrutura e Integração

● Além dos serviços principais, o projeto conta com uma infraestrutura de suporte para configuração, autenticação e comunicação entre os microserviços:

● hr-config-server: Centraliza todas as configurações dos serviços, utilizando repositório remoto no GitHub.

● hr-eureka-server: Registro de serviços (Service Discovery) para permitir a comunicação dinâmica entre os microserviços.

● hr-gateway-zuul: Gateway de entrada para as requisições externas, roteando para os serviços corretos.

● hr-oauth: Serviço de autenticação e autorização, responsável pela emissão e validação de tokens OAuth2 para os usuários e aplicações.

# Ambientes

● O projeto é preparado para rodar em diferentes ambientes, cada um com configurações específicas:

● Testes (test): Utiliza o banco de dados H2 em memória, facilitando os testes unitários e de integração.

● Desenvolvimento (dev): Utiliza PostgreSQL como banco de dados, com foco em testes manuais e desenvolvimento local.

● Produção (prod): Todos os serviços são empacotados em containers Docker e orquestrados de forma automatizada.

# Docker e Orquestração

● Na branch docker, você encontra o passo a passo para levantar toda a estrutura do projeto com Docker, incluindo:

● Build das imagens dos microserviços.

● Levantamento dos containers com dependências corretas.

● Configuração das redes, volumes e variáveis de ambiente.

# Segurança

● Autenticação via OAuth2 com tokens JWT.

● Perfis de acesso controlados por roles.

● Acesso ao serviço hr-payroll restrito a administradores.

# Atenção: Compatível para versões Java 11 e Spring Boot 2.3.4

# Checklist baixar e executar projeto pronto

● JDK 11, variáveis PATH e JAVA_HOME

● Configurar IDE para pegar Java 11

● Importar projetos na IDE

● Configurar credenciais do config server

● Preparar Postman (collection e environment)

● Subir projetos em ordem:

● Config server

● Eureka server

● Outros

# Modelo Conceitual :

![img7](https://github.com/user-attachments/assets/fb4d74a7-e7ad-4b0e-af84-e1f30c316bb2)

# Estrutura dos Micro Serviços:

<img width="587" alt="imagemREADME2" src="https://github.com/user-attachments/assets/cd4300bb-27f1-4058-bed3-576d4d25bf35" />

# Micro Serviços em "Containers" Docker.

![imagesREADME3_page-0001](https://github.com/user-attachments/assets/e90f3ac1-7096-4806-a9e4-46f623604c4e)


# Sistema de Requisição e Autorização

<img width="578" alt="IMAGEMREADME3" src="https://github.com/user-attachments/assets/324f7b7f-e3a5-4525-b1a0-0f5f61208d0f" />


# Modelo de Interface/Autorização/Segurança

<img width="581" alt="IMAGEMREADME4" src="https://github.com/user-attachments/assets/108a66d9-5af8-4d72-a0f5-066718f2850f" />


# Autor : 

Gabriel Nilson Espindola

🔗 https://www.linkedin.com/in/gabriel-nilson-espindola-065694297/


