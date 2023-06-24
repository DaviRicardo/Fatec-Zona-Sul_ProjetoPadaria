-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema projetoPadaria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `projetoPadaria` DEFAULT CHARACTER SET utf8 ;
USE `projetoPadaria` ;

-- -----------------------------------------------------
-- Table `projetoPadaria`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetoPadaria`.`pessoa` (
  `id_pessoa` INT NOT NULL AUTO_INCREMENT,
  `nome_pessoa` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_pessoa`),
  UNIQUE INDEX `id_pessoa_UNIQUE` (`id_pessoa` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetoPadaria`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetoPadaria`.`pedido` (
  `id_pedido` INT NOT NULL AUTO_INCREMENT,
  `pessoa_id_pessoa` INT NOT NULL,
  `valor_total` FLOAT NOT NULL,
  `data_pedido` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_pedido`, `pessoa_id_pessoa`),
  UNIQUE INDEX `id_pedido_UNIQUE` (`id_pedido` ASC),
  INDEX `fk_pedido_pessoa1_idx` (`pessoa_id_pessoa` ASC),
  CONSTRAINT `fk_pedido_pessoa1`
    FOREIGN KEY (`pessoa_id_pessoa`)
    REFERENCES `projetoPadaria`.`pessoa` (`id_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetoPadaria`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetoPadaria`.`produto` (
  `id_produto` INT NOT NULL AUTO_INCREMENT,
  `nome_produto` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `preco_unitario` FLOAT NOT NULL,
  PRIMARY KEY (`id_produto`),
  UNIQUE INDEX `id_produto_UNIQUE` (`id_produto` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetoPadaria`.`produto_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetoPadaria`.`produto_pedido` (
  `id_produto_pedido` INT NOT NULL AUTO_INCREMENT,
  `produto_id_produto` INT NOT NULL,
  `pedido_id_pedido` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `preco` FLOAT NOT NULL,
  PRIMARY KEY (`produto_id_produto`, `pedido_id_pedido`, `id_produto_pedido`),
  INDEX `fk_produto_has_pedido_pedido1_idx` (`pedido_id_pedido` ASC),
  INDEX `fk_produto_has_pedido_produto_idx` (`produto_id_produto` ASC),
  UNIQUE INDEX `id_produto_pedido_UNIQUE` (`id_produto_pedido` ASC),
  CONSTRAINT `fk_produto_has_pedido_produto`
    FOREIGN KEY (`produto_id_produto`)
    REFERENCES `projetoPadaria`.`produto` (`id_produto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_has_pedido_pedido1`
    FOREIGN KEY (`pedido_id_pedido`)
    REFERENCES `projetoPadaria`.`pedido` (`id_pedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetoPadaria`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetoPadaria`.`endereco` (
  `id_endereco` INT NOT NULL AUTO_INCREMENT,
  `pessoa_id_pessoa` INT NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_endereco`, `pessoa_id_pessoa`),
  INDEX `fk_endereco_pessoa1_idx` (`pessoa_id_pessoa` ASC),
  CONSTRAINT `fk_endereco_pessoa1`
    FOREIGN KEY (`pessoa_id_pessoa`)
    REFERENCES `projetoPadaria`.`pessoa` (`id_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetoPadaria`.`estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetoPadaria`.`estoque` (
  `id_estoque` INT NOT NULL AUTO_INCREMENT,
  `nome_estoque` VARCHAR(45) NOT NULL,
  `localizacao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_estoque`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetoPadaria`.`produto_estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projetoPadaria`.`produto_estoque` (
  `id_produto_estoque` INT NOT NULL AUTO_INCREMENT,
  `produto_id_produto` INT NOT NULL,
  `estoque_id_estoque` INT NOT NULL,
  `qntd_produto` INT NOT NULL,
  `data_entrada` VARCHAR(45) NOT NULL,
  `data_validade` VARCHAR(45),
  PRIMARY KEY (`produto_id_produto`, `estoque_id_estoque`, `id_produto_estoque`),
  INDEX `fk_produto_has_estoque_estoque1_idx` (`estoque_id_estoque` ASC),
  INDEX `fk_produto_has_estoque_produto1_idx` (`produto_id_produto` ASC),
  UNIQUE INDEX `id_produto_estoque_UNIQUE` (`id_produto_estoque` ASC),
  CONSTRAINT `fk_produto_has_estoque_produto1`
    FOREIGN KEY (`produto_id_produto`)
    REFERENCES `projetoPadaria`.`produto` (`id_produto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_has_estoque_estoque1`
    FOREIGN KEY (`estoque_id_estoque`)
    REFERENCES `projetoPadaria`.`estoque` (`id_estoque`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
