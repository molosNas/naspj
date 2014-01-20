SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `nasdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `nasdb` ;

-- -----------------------------------------------------
-- Table `nasdb`.`typedivers_modeltype`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nasdb`.`typedivers_modeltype` ;

CREATE TABLE IF NOT EXISTS `nasdb`.`typedivers_modeltype` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` VARCHAR(45) NOT NULL COMMENT '种类名称',
  `description` VARCHAR(255) NULL COMMENT '种类描述',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `model_type_name_UNIQUE` (`name` ASC))
ENGINE = InnoDB
COMMENT = '信息表：型号种类';


-- -----------------------------------------------------
-- Table `nasdb`.`pdt_model`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nasdb`.`pdt_model` ;

CREATE TABLE IF NOT EXISTS `nasdb`.`pdt_model` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code_id` VARCHAR(45) NULL COMMENT '型号编码，副健，编码唯一，经常用到，长度固定',
  `name` VARCHAR(45) NOT NULL COMMENT '模型名称 ,命名规范',
  `description` VARCHAR(255) NULL COMMENT '模型描述',
  `date_creation` DATETIME NOT NULL COMMENT '创建日期 自动添加',
  `date_modification` DATETIME NOT NULL COMMENT '修改日期 自动添加',
  `date_delete` DATETIME NOT NULL COMMENT '删除日期 自动添加',
  `modeltype_ref` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `model_name_UNIQUE` (`name` ASC),
  INDEX `fk_model_model_type1_idx` (`modeltype_ref` ASC),
  UNIQUE INDEX `model_id_UNIQUE` (`code_id` ASC),
  CONSTRAINT `fk_model_model_type1`
    FOREIGN KEY (`modeltype_ref`)
    REFERENCES `nasdb`.`typedivers_modeltype` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '基本表：型号';


-- -----------------------------------------------------
-- Table `nasdb`.`pdt_component`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nasdb`.`pdt_component` ;

CREATE TABLE IF NOT EXISTS `nasdb`.`pdt_component` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code_id` VARCHAR(25) NULL COMMENT '组件编码，候补键，命名规范',
  `name` VARCHAR(45) NOT NULL COMMENT '组件名称',
  `description` VARCHAR(255) NULL COMMENT '组件描述',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `component_name_UNIQUE` (`name` ASC))
ENGINE = InnoDB
COMMENT = '基本表：组件';


-- -----------------------------------------------------
-- Table `nasdb`.`typedivers_annextype`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nasdb`.`typedivers_annextype` ;

CREATE TABLE IF NOT EXISTS `nasdb`.`typedivers_annextype` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` VARCHAR(45) NOT NULL COMMENT '附属种类名称  基本，特例',
  `description` VARCHAR(255) NULL COMMENT '种类描述',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `annex_type_name_UNIQUE` (`name` ASC))
ENGINE = InnoDB
COMMENT = '其他表：附加种类';


-- -----------------------------------------------------
-- Table `nasdb`.`ref_model_component`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nasdb`.`ref_model_component` ;

CREATE TABLE IF NOT EXISTS `nasdb`.`ref_model_component` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `model_ref` INT NOT NULL COMMENT '型号引用',
  `component_ref` INT NOT NULL COMMENT '组件引用',
  `annextype_ref` INT NOT NULL COMMENT '种类（基本，特例）',
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  PRIMARY KEY (`id`),
  INDEX `fk_ref_model_component_model1_idx` (`model_ref` ASC),
  INDEX `fk_ref_model_component_component1_idx` (`component_ref` ASC),
  INDEX `fk_ref_model_component_type_divers_annex_type1_idx` (`annextype_ref` ASC),
  CONSTRAINT `fk_ref_model_component_model1`
    FOREIGN KEY (`model_ref`)
    REFERENCES `nasdb`.`pdt_model` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ref_model_component_component1`
    FOREIGN KEY (`component_ref`)
    REFERENCES `nasdb`.`pdt_component` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ref_model_component_type_divers_annex_type1`
    FOREIGN KEY (`annextype_ref`)
    REFERENCES `nasdb`.`typedivers_annextype` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '关系表：型号种类组件种类 多对多';


-- -----------------------------------------------------
-- Table `nasdb`.`typedivers_attributetype`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nasdb`.`typedivers_attributetype` ;

CREATE TABLE IF NOT EXISTS `nasdb`.`typedivers_attributetype` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` VARCHAR(45) NOT NULL COMMENT '属性名称',
  `description` VARCHAR(255) NULL COMMENT '属性描述',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `attribute_type_name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nasdb`.`pdt_attribute`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nasdb`.`pdt_attribute` ;

CREATE TABLE IF NOT EXISTS `nasdb`.`pdt_attribute` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code_id` VARCHAR(25) NULL COMMENT '属性编码',
  `name` VARCHAR(45) NOT NULL COMMENT '属性名称',
  `description` VARCHAR(255) NULL,
  `attributetype_ref` INT NOT NULL COMMENT '属性所属(基本特例)',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `attribute_name_UNIQUE` (`name` ASC),
  INDEX `fk_pdt_attribute_type_divers_attribute_type1_idx` (`attributetype_ref` ASC),
  CONSTRAINT `fk_pdt_attribute_type_divers_attribute_type1`
    FOREIGN KEY (`attributetype_ref`)
    REFERENCES `nasdb`.`typedivers_attributetype` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '基本表：属性';


-- -----------------------------------------------------
-- Table `nasdb`.`typedivers_propositiontype`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nasdb`.`typedivers_propositiontype` ;

CREATE TABLE IF NOT EXISTS `nasdb`.`typedivers_propositiontype` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` VARCHAR(45) NOT NULL COMMENT '方案大类名称',
  `description` VARCHAR(255) NULL COMMENT '属性描述',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `proposition_type_name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nasdb`.`pdt_proposition`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nasdb`.`pdt_proposition` ;

CREATE TABLE IF NOT EXISTS `nasdb`.`pdt_proposition` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code_id` VARCHAR(45) NULL COMMENT '方案编码',
  `name` VARCHAR(45) NOT NULL COMMENT '方案名称',
  `description` VARCHAR(255) NULL COMMENT '方案描述',
  `attributetype_ref` INT NOT NULL COMMENT '方案所属属性大类',
  `propositiontype_ref` INT NOT NULL COMMENT '方案种类（输入，选择）',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `proposal_name_UNIQUE` (`name` ASC),
  INDEX `fk_pdt_proposition_type_divers_attribute_type1_idx` (`attributetype_ref` ASC),
  INDEX `fk_pdt_proposition_type_divers_proposition_type1_idx` (`propositiontype_ref` ASC),
  CONSTRAINT `fk_pdt_proposition_type_divers_attribute_type1`
    FOREIGN KEY (`attributetype_ref`)
    REFERENCES `nasdb`.`typedivers_attributetype` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pdt_proposition_type_divers_proposition_type1`
    FOREIGN KEY (`propositiontype_ref`)
    REFERENCES `nasdb`.`typedivers_propositiontype` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '基本表：方案';


-- -----------------------------------------------------
-- Table `nasdb`.`metaprocedure`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nasdb`.`metaprocedure` ;

CREATE TABLE IF NOT EXISTS `nasdb`.`metaprocedure` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
COMMENT = '基本表：元工序表';


-- -----------------------------------------------------
-- Table `nasdb`.`ref_modelcomponent_attribute_proposition`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nasdb`.`ref_modelcomponent_attribute_proposition` ;

CREATE TABLE IF NOT EXISTS `nasdb`.`ref_modelcomponent_attribute_proposition` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `model_component_ref` INT NOT NULL COMMENT '型号组件关系引用',
  `attribute_ref` INT NOT NULL COMMENT '属性引用',
  `annextype_ref` INT NOT NULL COMMENT '类型，是否特例订制',
  `proposition_ref` INT NOT NULL COMMENT '方案引用',
  `metaprocedure_ref` INT NOT NULL COMMENT '对应的元工序',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_ref_modelcomponent_attribute_proposition_attribute1_idx` (`attribute_ref` ASC),
  INDEX `fk_ref_modelcomponent_attribute_proposition_ref_model_compo_idx` (`model_component_ref` ASC),
  INDEX `fk_ref_modelcomponent_attribute_proposition_proposition1_idx` (`proposition_ref` ASC),
  INDEX `fk_ref_modelcomponent_attribute_proposition_meta_procedure1_idx` (`metaprocedure_ref` ASC),
  INDEX `fk_ref_modelcomponent_attribute_proposition_type_divers_ann_idx` (`annextype_ref` ASC),
  CONSTRAINT `fk_ref_modelcomponent_attribute_proposition_attribute1`
    FOREIGN KEY (`attribute_ref`)
    REFERENCES `nasdb`.`pdt_attribute` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ref_modelcomponent_attribute_proposition_ref_model_compone1`
    FOREIGN KEY (`model_component_ref`)
    REFERENCES `nasdb`.`ref_model_component` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ref_modelcomponent_attribute_proposition_proposition1`
    FOREIGN KEY (`proposition_ref`)
    REFERENCES `nasdb`.`pdt_proposition` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ref_modelcomponent_attribute_proposition_meta_procedure1`
    FOREIGN KEY (`metaprocedure_ref`)
    REFERENCES `nasdb`.`metaprocedure` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ref_modelcomponent_attribute_proposition_type_divers_annex1`
    FOREIGN KEY (`annextype_ref`)
    REFERENCES `nasdb`.`typedivers_annextype` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '扩展表：属性种类';


-- -----------------------------------------------------
-- Table `nasdb`.`pdt_element`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nasdb`.`pdt_element` ;

CREATE TABLE IF NOT EXISTS `nasdb`.`pdt_element` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code_id` VARCHAR(25) NULL COMMENT '元素编码',
  `name` VARCHAR(45) NOT NULL COMMENT '值名称',
  `description` VARCHAR(255) NULL COMMENT '属性描述',
  `samplepath` VARCHAR(255) NULL COMMENT '示例路径',
  `attributetype_ref` INT NOT NULL COMMENT '外键引用，属性大类',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `value_name_UNIQUE` (`name` ASC),
  INDEX `fk_pdt_element_type_divers_attribute_type1_idx` (`attributetype_ref` ASC),
  CONSTRAINT `fk_pdt_element_type_divers_attribute_type1`
    FOREIGN KEY (`attributetype_ref`)
    REFERENCES `nasdb`.`typedivers_attributetype` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '基本表：值';


-- -----------------------------------------------------
-- Table `nasdb`.`ref_proposition_element`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nasdb`.`ref_proposition_element` ;

CREATE TABLE IF NOT EXISTS `nasdb`.`ref_proposition_element` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `proposition_ref` INT NOT NULL COMMENT '外键引用 方案',
  `element_ref` INT NOT NULL COMMENT '外键引用 值',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_ref_proposition_value_proposition1_idx` (`proposition_ref` ASC),
  INDEX `fk_ref_proposition_value_value1_idx` (`element_ref` ASC),
  CONSTRAINT `fk_ref_proposition_value_proposition1`
    FOREIGN KEY (`proposition_ref`)
    REFERENCES `nasdb`.`pdt_proposition` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ref_proposition_value_value1`
    FOREIGN KEY (`element_ref`)
    REFERENCES `nasdb`.`pdt_element` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '扩展表：方案';


-- -----------------------------------------------------
-- Table `nasdb`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nasdb`.`order` ;

CREATE TABLE IF NOT EXISTS `nasdb`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code_id` VARCHAR(45) NOT NULL COMMENT '模型名称  命名规范',
  `date_creation` DATETIME NOT NULL COMMENT '创建日期 自动添加',
  `date_modification` DATETIME NOT NULL COMMENT '修改日期 自动添加',
  `date_delete` DATETIME NOT NULL COMMENT '删除日期 自动添加',
  `total_price` INT NULL COMMENT '总价 可选',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `order_id_UNIQUE` (`code_id` ASC))
ENGINE = InnoDB
COMMENT = '基本表：订单';


-- -----------------------------------------------------
-- Table `nasdb`.`sheet_handle_history`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nasdb`.`sheet_handle_history` ;

CREATE TABLE IF NOT EXISTS `nasdb`.`sheet_handle_history` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
COMMENT = '扩展表：单据操作历史';


-- -----------------------------------------------------
-- Table `nasdb`.`work_sheet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nasdb`.`work_sheet` ;

CREATE TABLE IF NOT EXISTS `nasdb`.`work_sheet` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
COMMENT = '基本表';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
