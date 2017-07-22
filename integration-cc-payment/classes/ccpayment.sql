DROP TABLE IF EXISTS `cc`.`ccpayments`;
CREATE TABLE  `cc`.`ccpayments` (
  `ccpaymentsID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `merchantID` varchar(45) NOT NULL DEFAULT '',
  `merchantReferenceCode` varchar(45) NOT NULL DEFAULT '',
  `firstName` varchar(45) NOT NULL DEFAULT '',
  `lastName` varchar(45) NOT NULL DEFAULT '',
  `accountNumber` varchar(16000) NOT NULL DEFAULT '',
  `requestID` varchar(45) NOT NULL DEFAULT '',
  `decision` varchar(45) NOT NULL DEFAULT '',
  `reasonCode` varchar(45) NOT NULL DEFAULT '',
  `requestToken` varchar(500) NOT NULL DEFAULT '',
  `status` varchar(45) NOT NULL DEFAULT '',
  `dateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateUpdated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ccpaymentsID`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;