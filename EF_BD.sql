-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema EF_BD
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema EF_BD
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `EF_BD` DEFAULT CHARACTER SET utf8 ;
USE `EF_BD` ;

-- -----------------------------------------------------
-- Table `EF_BD`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EF_BD`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `correo` VARCHAR(100) NULL,
  `contrasena` VARCHAR(512) NULL,
  `tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EF_BD`.`Impresion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EF_BD`.`Impresion` (
  `idImpresion` INT NOT NULL,
  `densidad` INT NULL,
  `grosor` VARCHAR(45) NULL,
  `altura` FLOAT NULL,
  `material` VARCHAR(45) NULL,
  `url` VARCHAR(200) NULL,
  `autoservicio` TINYINT NULL,
  `costo` FLOAT NULL,
  `tiempo` FLOAT NULL,
  `fecha` DATE NULL,
  `Usuario_idUsuario` INT NOT NULL,
  `aprobado` TINYINT NULL,
  `motivorechazo` VARCHAR(200) NULL,
  PRIMARY KEY (`idImpresion`),
  INDEX `fk_Impresion_Usuario_idx` (`Usuario_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Impresion_Usuario`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `EF_BD`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EF_BD`.`Laser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EF_BD`.`Laser` (
  `idCorte` INT NOT NULL,
  `grosor` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  `material` VARCHAR(45) NULL,
  `dimensiones` FLOAT NULL,
  `url` VARCHAR(200) NULL,
  `costo` FLOAT NULL,
  `tiempo` FLOAT NULL,
  `fecha` DATE NULL,
  `Usuario_idUsuario` INT NOT NULL,
  `aprobado` TINYINT NULL,
  `motivorechazo` VARCHAR(200) NULL,
  PRIMARY KEY (`idCorte`),
  INDEX `fk_Laser_Usuario1_idx` (`Usuario_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Laser_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `EF_BD`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EF_BD`.`Escaneo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EF_BD`.`Escaneo` (
  `idEscaneo` INT NOT NULL,
  `largo` FLOAT NULL,
  `ancho` FLOAT NULL,
  `altura` FLOAT NULL,
  `resolucion` VARCHAR(45) NULL,
  `costo` FLOAT NULL,
  `tiempo` FLOAT NULL,
  `fecha` DATE NULL,
  `Usuario_idUsuario` INT NOT NULL,
  `aprobado` TINYINT NULL,
  `motivorechazo` VARCHAR(200) NULL,
  PRIMARY KEY (`idEscaneo`),
  INDEX `fk_Escaneo_Usuario1_idx` (`Usuario_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Escaneo_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `EF_BD`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
