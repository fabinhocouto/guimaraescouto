

-- Table: cliente

DROP TABLE cliente;

CREATE TABLE cliente
(
  id serial NOT NULL,
  nome character varying(255) NOT NULL,
  endereco character varying(255),
  telefone character varying(50),
  CONSTRAINT cliente_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE cliente
  OWNER TO postgres;


-- Table: fornecedor

DROP TABLE fornecedor;

CREATE TABLE fornecedor
(
  id serial NOT NULL,
  nome character varying(255) NOT NULL,
  telefone character varying(50),
  CONSTRAINT fornecedor_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE fornecedor
  OWNER TO postgres;

-- Table: usuario

DROP TABLE usuario;

CREATE TABLE usuario
(
  id serial NOT NULL,
  nome character varying(255) NOT NULL,
  usuario character varying(255) NOT NULL,
  senha character varying(32) NOT NULL,
  CONSTRAINT usuario_pkey PRIMARY KEY (id),
  CONSTRAINT usuario_usuario_key UNIQUE (usuario)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE usuario
  OWNER TO postgres;

-- Table: produto

DROP TABLE produto;

CREATE TABLE produto
(
  id serial NOT NULL,
  descricao character varying(255) NOT NULL,
  preco numeric(10,2),
  codigo_barras character varying(20),
  secao boolean,
  CONSTRAINT produto_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE produto
  OWNER TO postgres;

-- Table: itens_venda

DROP TABLE itens_venda;

CREATE TABLE itens_venda
(
  id serial NOT NULL,
  id_produto integer NOT NULL,
  qtd numeric NOT NULL DEFAULT 1,
  id_venda integer NOT NULL,
  preco_unitario numeric(10,2) NOT NULL,
  CONSTRAINT itens_venda_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE itens_venda
  OWNER TO postgres;


-- Table: venda

DROP TABLE venda;

CREATE TABLE venda
(
  id integer NOT NULL,
  id_usuario integer,
  data_venda date NOT NULL,
  total numeric(10,2) NOT NULL DEFAULT 0,
  id_cliente integer NOT NULL,
  CONSTRAINT venda_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE venda
  OWNER TO postgres;

-- Table: pagamento

-- DROP TABLE pagamento;

CREATE TABLE pagamento
(
  id serial,
  valor_pagamento numeric(10,2),
  data_pagamento date,
  id_cliente integer NOT NULL,
)
WITH (
  OIDS=FALSE
);
ALTER TABLE pagamento
  OWNER TO postgres;
