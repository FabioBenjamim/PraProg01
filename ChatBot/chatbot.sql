DROP DATABASE IF EXISTS chatbot;
CREATE DATABASE IF NOT EXISTS chatbot DEFAULT CHARACTER SET utf8 ;
USE chatbot ;

CREATE TABLE IF NOT EXISTS Resposta(
	id_Resposta INT NOT NULL AUTO_INCREMENT,
    resposta_Resposta VARCHAR(100) NOT NULL,
  PRIMARY KEY (id_Resposta))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS Cliente (
  id_Cliente INT(10) NOT NULL,
  nome_Cliente VARCHAR(45) NOT NULL,
  cpf_Cliente int(11) NOT NULL,
  email_Cliente VARCHAR(45) NOT NULL,
  telefone_Ciente VARCHAR(45) NOT NULL,
  data_nascismento_Cliente DATE NOT NULL,
  PRIMARY KEY (id_cliente),
  UNIQUE INDEX cpf_Cliente_UNIQUE (cpf_Cliente ASC))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS Pergunta (
  id_Pergunta INT NOT NULL AUTO_INCREMENT,
  pergunta_Pergunta VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_Pergunta))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS Atendente (
  id_Atendente INT NOT NULL AUTO_INCREMENT,
  nome_Atendente VARCHAR(45) NOT NULL,
  cpf_Atendente VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_Atendente))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS Atendimento (
  id_Atendimento INT NOT NULL AUTO_INCREMENT,
  Cliente_id_Cliente INT(10) NOT NULL,
  Pergunta_id_Pergunta INT NOT NULL,
  Atendente_id_Atendente INT NOT NULL,
  PRIMARY KEY (id_Atendimento),
  INDEX fk_Atendimento_Cliente1_idx (Cliente_id_Cliente ASC),
  INDEX fk_Atendimento_Pergunta1_idx (Pergunta_id_Pergunta ASC),
  INDEX fk_Atendimento_Atendente1_idx (Atendente_id_Atendente ASC),
  CONSTRAINT fk_Atendimento_Cliente1
    FOREIGN KEY (Cliente_id_Cliente)
    REFERENCES Cliente (id_Cliente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Atendimento_Pergunta1
    FOREIGN KEY (Pergunta_id_Pergunta)
    REFERENCES Pergunta (id_Pergunta)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Atendimento_Atendente1
    FOREIGN KEY (Atendente_id_Atendente)
    REFERENCES Atendente (id_Atendente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS Palavra_Chave (
  id_Palavra_Chave INT NOT NULL ,
  palavra_Palavra VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_Palavra_Chave))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS Resposta_has_Palavra_Chave (
  Resposta_id_Resposta INT NOT NULL,
  Palavra_Chave_id_Palavra_Chave INT NOT NULL,
  PRIMARY KEY (Resposta_id_Resposta, Palavra_Chave_id_Palavra_Chave),
  INDEX fk_Resposta_has_Palavra_Chave_Palavra_Chave1_idx (Palavra_Chave_id_Palavra_Chave ASC),
  INDEX fk_Resposta_has_Palavra_Chave_Resposta_idx (Resposta_id_Resposta ASC),
  CONSTRAINT fk_Resposta_has_Palavra_Chave_Resposta
    FOREIGN KEY (Resposta_id_Resposta)
    REFERENCES Resposta (id_Resposta)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Resposta_has_Palavra_Chave_Palavra_Chave1
    FOREIGN KEY (Palavra_Chave_id_Palavra_Chave)
    REFERENCES Palavra_Chave (id_Palavra_Chave)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS Palavra_Chave_has_Pergunta (
  Palavra_Chave_id_Palavra_Chave INT NOT NULL,
  Pergunta_id_Pergunta INT NOT NULL,
  PRIMARY KEY (Palavra_Chave_id_Palavra_Chave, Pergunta_id_Pergunta),
  INDEX fk_Palavra_Chave_has_Pergunta_Pergunta1_idx (Pergunta_id_Pergunta ASC),
  INDEX fk_Palavra_Chave_has_Pergunta_Palavra_Chave1_idx (Palavra_Chave_id_Palavra_Chave ASC),
  CONSTRAINT fk_Palavra_Chave_has_Pergunta_Palavra_Chave1
    FOREIGN KEY (Palavra_Chave_id_Palavra_Chave)
    REFERENCES Palavra_Chave (id_Palavra_Chave)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Palavra_Chave_has_Pergunta_Pergunta1
    FOREIGN KEY (Pergunta_id_Pergunta)
    REFERENCES Pergunta (id_Pergunta)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS Atendimento_has_Resposta (
  Atendimento_id_Atendimento INT NOT NULL,
  Resposta_id_Resposta INT NOT NULL,
  PRIMARY KEY (Atendimento_id_Atendimento, Resposta_id_Resposta),
  INDEX fk_Atendimento_has_Resposta_Resposta1_idx (Resposta_id_Resposta ASC),
  INDEX fk_Atendimento_has_Resposta_Atendimento1_idx (Atendimento_id_Atendimento ASC),
  CONSTRAINT fk_Atendimento_has_Resposta_Atendimento1
    FOREIGN KEY (Atendimento_id_Atendimento)
    REFERENCES Atendimento (id_Atendimento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Atendimento_has_Resposta_Resposta1
    FOREIGN KEY (Resposta_id_Resposta)
    REFERENCES Resposta (id_Resposta)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;