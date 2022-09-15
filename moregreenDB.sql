-- -----------------------------------------------------
-- Schema moregreen
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `moregreen` DEFAULT CHARACTER SET utf8 ;
USE `moregreen` ;

-- -----------------------------------------------------
-- Table `moregreen`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moregreen`.`member` (
  `m_num` INT NOT NULL AUTO_INCREMENT,
  `m_id` VARCHAR(60) NOT NULL,
  `m_pw` VARCHAR(60) NOT NULL,
  `m_email` VARCHAR(60) NOT NULL,
  `m_exit` CHAR(1) NOT NULL DEFAULT 'N',
  `m_exitdate` DATE NULL,
  PRIMARY KEY (`m_num`)
  );


-- -----------------------------------------------------
-- Table `moregreen`.`funding`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moregreen`.`funding` (
  `f_num` INT NOT NULL AUTO_INCREMENT, #펀딩 번호	
  `f_title` VARCHAR(60) NOT NULL, #펀딩 명칭
  `f_content` VARCHAR(16000) NOT NULL, #내용
  `f_days` INT NOT NULL, #펀딩 기간
  `f_enddate` DATE NOT NULL, #마감일
  `f_target` INT NOT NULL DEFAULT 500000, #목표 금액
  `f_totalmoney` INT NOT NULL DEFAULT 0, #현재 금액
  `f_rate` DOUBLE NOT NULL NULL DEFAULT 0.0, #펀딩률
  `f_status` INT NOT NULL DEFAULT 1, #진행 상태
  `f_reward` VARCHAR(60) NOT NULL, #리워드 명칭
  `f_price` INT NOT NULL, #리워드 금액
  `f_bname` VARCHAR(60) NOT NULL, #상호명
  `f_bnum` CHAR(10) NOT NULL, #사업자 번호
  `f_regdate` DATE NOT NULL DEFAULT (current_date()), #신청 일자
  `member_m_num` INT NOT NULL,
  PRIMARY KEY (`f_num`),
  CONSTRAINT `fk_funding_member1`
    FOREIGN KEY (`member_m_num`)
    REFERENCES `moregreen`.`member` (`m_num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
#insert into funding (f_title, f_content, f_days, f_reward, f_price, f_bname, f_bnum) values('test', 'test', 30, 'test', 30000, 'test', '111111');
-- -----------------------------------------------------
-- Table `moregreen`.`like`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moregreen`.`f_like` (
  `l_num` INT NOT NULL AUTO_INCREMENT,
  `member_m_num` INT NOT NULL,
  `funding_f_num` INT NOT NULL,
  PRIMARY KEY (`l_num`),
  CONSTRAINT `fk_like_member1`
    FOREIGN KEY (`member_m_num`)
    REFERENCES `moregreen`.`member` (`m_num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_like_funding1`
    FOREIGN KEY (`funding_f_num`)
    REFERENCES `moregreen`.`funding` (`f_num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Table `moregreen`.`delivery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moregreen`.`delivery` (
  `d_num` INT NOT NULL AUTO_INCREMENT,
  `d_name` VARCHAR(60) NULL,
  `d_phone` CHAR(11) NULL,
  `d_zipcode` CHAR(5) NULL,
  `d_addr` VARCHAR(60) NULL,
  `d_detailaddr` VARCHAR(60) NULL,
  PRIMARY KEY (`d_num`)
);


-- -----------------------------------------------------
-- Table `moregreen`.`purchase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moregreen`.`purchase` (
  `p_num` INT NOT NULL AUTO_INCREMENT,
  `p_payment` INT NULL,
  `p_amount` INT NULL,
  `p_total` INT NULL,
  `p_method` INT NULL,
  `p_date` DATE NULL,
  `delivery_d_num` INT NOT NULL,
  `member_m_num` INT NOT NULL,
  `funding_f_num` INT NOT NULL,
  PRIMARY KEY (`p_num`, `delivery_d_num`),
  CONSTRAINT `fk_purchase_delivery`
    FOREIGN KEY (`delivery_d_num`)
    REFERENCES `moregreen`.`delivery` (`d_num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_member1`
    FOREIGN KEY (`member_m_num`)
    REFERENCES `moregreen`.`member` (`m_num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_funding1`
    FOREIGN KEY (`funding_f_num`)
    REFERENCES `moregreen`.`funding` (`f_num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);



-- -----------------------------------------------------
-- Table `moregreen`.`alarm`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moregreen`.`alarm` (
  `a_num` INT NOT NULL AUTO_INCREMENT,
  `a_message` VARCHAR(500) NULL,
  `funding_f_num` INT NOT NULL,
  PRIMARY KEY (`a_num`, `funding_f_num`),
  CONSTRAINT `fk_alarm_funding1`
    FOREIGN KEY (`funding_f_num`)
    REFERENCES `moregreen`.`funding` (`f_num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


-- -----------------------------------------------------
-- Table `moregreen`.`image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moregreen`.`image` (
  `i_num` INT NOT NULL AUTO_INCREMENT,
  `i_name` VARCHAR(60) NULL,
  `i_path` VARCHAR(60) NULL,
  `i_uuid` VARCHAR(60) NULL,
  `i_regdate` TIMESTAMP NULL DEFAULT NOW(),
  `i_type` INT NULL,
  `funding_f_num` INT NOT NULL,
  `m_id` VARCHAR(60) NULL,
  PRIMARY KEY (`i_num`),
  CONSTRAINT `fk_image_funding1`
    FOREIGN KEY (`funding_f_num`)
    REFERENCES `moregreen`.`funding` (`f_num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

