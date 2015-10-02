# dwm2015
Material para pessoal da Pós de desenvolvimento de sistemas web e mobile 2015

Utilizar a SQL abaixo para criar a tabela de usuários no banco de dados para testarmos SpringSecurity. Após a criação, configurar a aplicação e por último fazer a engenharia reversa da tabela para criação do modelo.


`CREATE TABLE usuario
(
  id_usuario serial NOT NULL,
  nome character varying(100) NOT NULL,
  login character varying(25),
  senha character varying,
  email character varying(120),
  ativo boolean,
  permissao character varying(100),
  CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario)
)`
