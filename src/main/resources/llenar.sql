DROP TABLE IF EXISTS `TOFM_LINK_ART_BTW`;
CREATE TABLE `TOFM_LINK_ART_BTW` (
  `LAB_ART_ID` int(11) NOT NULL DEFAULT '0',
  `LAB_CODIGO_GENERO` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`LAB_ART_ID`,`LAB_CODIGO_GENERO`),
  KEY `index_lab` (`LAB_ART_ID`),
  KEY `index_lab2` (`LAB_CODIGO_GENERO`)
) ENGINE=MEMORY;

DROP TABLE IF EXISTS `TOF_ARTICLES`;
CREATE TABLE `TOF_ARTICLES` (
  `ART_ID` int(11) NOT NULL DEFAULT '0',
  `ART_ARTICLE_NR` varchar(50) DEFAULT NULL,
  `ART_SUP_ID` int(11) DEFAULT NULL,
  `ART_DES_ID` int(11) DEFAULT NULL,
  `ART_COMPLETE_DES_ID` int(11) DEFAULT NULL,
  `ART_CTM` text,
  `ART_PACK_SELFSERVICE` text,
  `ART_MATERIAL_MARK` text,
  `ART_REPLACEMENT` text,
  `ART_ACCESSORY` text,
  `ART_BATCH_SIZE1` int(11) DEFAULT NULL,
  `ART_BATCH_SIZE2` int(11) DEFAULT NULL,
  PRIMARY KEY (`ART_ID`),
  KEY `index_art2` (`ART_ARTICLE_NR`,`ART_SUP_ID`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `TOF_ARTICLE_IMAGES`;
CREATE TABLE `TOF_ARTICLE_IMAGES` (
  `article_id` int(11) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `file_type` int(11) DEFAULT NULL
  , folder varchar(10)
  , KEY `article_id` (`article_id`, file_type)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `TOF_ART_LOOKUP`;
CREATE TABLE `TOF_ART_LOOKUP` (
  `ARL_ART_ID` int(11) DEFAULT NULL,
  `ARL_SEARCH_NUMBER` varchar(50) DEFAULT NULL,
  `ARL_KIND` int,
  `ARL_CTM` text,
  `ARL_BRA_ID` int(11) DEFAULT NULL,
  `ARL_DISPLAY_NR` varchar(50),
  `ARL_DISPLAY` int,
  `ARL_BLOCK` varchar(50),
  `ARL_SORT` int
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `TOF_BRANDS`;
CREATE TABLE `TOF_BRANDS` (
  `BRA_ID` int,
  `BRA_MFC_CODE` text,
  `BRA_BRAND` text,
  `BRA_MF_NR` int(11) DEFAULT NULL,
  `BRA_STATUS` int(11) DEFAULT NULL
  , primary key(BRA_ID)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `TOF_COUNTRY_DESIGNATIONS`;
CREATE TABLE `TOF_COUNTRY_DESIGNATIONS` (
  `CDS_ID` int(11) DEFAULT NULL,
  `CDS_CTM` text,
  `CDS_LNG_ID` int(11) DEFAULT NULL,
  `TEX_TEXT` text,
  KEY `index_cds` (`CDS_ID`,`CDS_LNG_ID`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `TOF_DESIGNATIONS`;
CREATE TABLE `TOF_DESIGNATIONS` (
  `DES_ID` int(11) NOT NULL DEFAULT '0',
  `DES_LNG_ID` int(11) NOT NULL DEFAULT '0',
  `TEX_TEXT` text,
  PRIMARY KEY (`DES_ID`,`DES_LNG_ID`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `TOF_ENGINES`;
CREATE TABLE `TOF_ENGINES` (
  `ENG_ID` int(11) NOT NULL DEFAULT '0',
  `ENG_MFA_ID` int,
  `ENG_CODE` varchar(250),
  `ENG_PCON_START` int(11) DEFAULT NULL,
  `ENG_PCON_END` int(11) DEFAULT NULL,
  `ENG_KW_FROM` int(11) DEFAULT NULL,
  `ENG_KW_UPTO` int(11) DEFAULT NULL,
  `ENG_HP_FROM` int(11) DEFAULT NULL,
  `ENG_HP_UPTO` int(11) DEFAULT NULL,
  `ENG_VALVES` text,
  `ENG_CYLINDERS` text,
  `ENG_CCM_FROM` int(11) DEFAULT NULL,
  `ENG_CCM_UPTO` int(11) DEFAULT NULL,
  `ENG_KV_DESIGN_DES_ID` int(11) DEFAULT NULL,
  `ENG_KV_FUEL_TYPE_DES_ID` int(11) DEFAULT NULL,
  `ENG_KV_FUEL_SUPPLY_DES_ID` int(11) DEFAULT NULL,
  `ENG_CTM` text,
  `ENG_LA_CTM` text,
  `ENG_DESCRIPTION` text,
  `ENG_KV_ENGINE_DES_ID` int(11) DEFAULT NULL,
  `ENG_KW_RPM_FROM` int(11) DEFAULT NULL,
  `ENG_KW_RPM_UPTO` int(11) DEFAULT NULL,
  `ENG_TORQUE_FROM` int(11) DEFAULT NULL,
  `ENG_TORQUE_UPTO` int(11) DEFAULT NULL,
  `ENG_TORQUE_RPM_FROM` int(11) DEFAULT NULL,
  `ENG_TORQUE_RPM_UPTO` int(11) DEFAULT NULL,
  `ENG_COMPRESSION_FROM` text,
  `ENG_COMPRESSION_UPTO` text,
  `ENG_DRILLING` text,
  `ENG_EXTENSION` text,
  `ENG_CRANKSHAFT` text,
  `ENG_KV_CHARGE_DES_ID` int(11) DEFAULT NULL,
  `ENG_KV_GAS_NORM_DES_ID` int(11) DEFAULT NULL,
  `ENG_KV_CYLINDERS_DES_ID` int(11) DEFAULT NULL,
  `ENG_KV_CONTROL_DES_ID` int(11) DEFAULT NULL,
  `ENG_KV_VALVE_CONTROL_DES_ID` int(11) DEFAULT NULL,
  `ENG_KV_COOLING_DES_ID` int(11) DEFAULT NULL,
  `ENG_CCM_TAX_FROM` int(11) DEFAULT NULL,
  `ENG_CCM_TAX_UPTO` int(11) DEFAULT NULL,
  `ENG_LITRES_TAX_FROM` text,
  `ENG_LITRES_TAX_UPTO` text,
  `ENG_LITRES_FROM` text,
  `ENG_LITRES_UPTO` text,
  `ENG_KV_USE_DES_ID` int(11) DEFAULT NULL,
  ENG_SEARCH varchar(250),
  PRIMARY KEY (`ENG_ID`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `TOF_LANGUAGES`;
CREATE TABLE `TOF_LANGUAGES` (
  `LNG_ID` text,
  `LNG_DES_ID` int(11) DEFAULT NULL,
  `LNG_ISO2` text,
  `LNG_CODEPAGE` text
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `TOF_LINK_ART`;
CREATE TABLE `TOF_LINK_ART` (
  `LA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LA_ART_ID` int(11) DEFAULT NULL,
  `LA_GA_ID` int(11) DEFAULT NULL,
  `LA_CTM` text,
  `LA_SORT` int(11) DEFAULT NULL,
  PRIMARY KEY (`LA_ID`),
  KEY `index_la` (`LA_ART_ID`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `TOF_LINK_ART_BTW`;
CREATE TABLE `TOF_LINK_ART_BTW` (
  `LAB_ART_ID` int(11) DEFAULT NULL,
  `LAB_CODIGO_GENERO` varchar(50) DEFAULT NULL,
  KEY `LAB_ART_ID` (`LAB_ART_ID`,`LAB_CODIGO_GENERO`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `TOF_LINK_GA_STR`;
CREATE TABLE `TOF_LINK_GA_STR` (
  `LGS_STR_ID` int(11) DEFAULT NULL,
  `LGS_GA_ID` int(11) DEFAULT NULL,
  KEY `index_lgs` (`LGS_STR_ID`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `TOF_LINK_LA_TYP`;
CREATE TABLE `TOF_LINK_LA_TYP` (
  `LAT_TYP_ID` int(11) DEFAULT NULL,
  `LAT_LA_ID` int(11) DEFAULT NULL,
  `LAT_GA_ID` int(11) DEFAULT NULL,
  `LAT_CTM` text,
  `LAT_SUP_ID` text,
  `LAT_SORT` int(11) DEFAULT NULL,
  KEY `index_lat2` (`LAT_LA_ID`),
  KEY `index_lat` (`LAT_LA_ID`),
  KEY `index_lat3` (`LAT_TYP_ID`,`LAT_GA_ID`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `TOF_LINK_TYP_ENG`;
CREATE TABLE `TOF_LINK_TYP_ENG` (
  `LTE_TYP_ID` int(11) DEFAULT NULL,
  `LTE_NR` text,
  `LTE_ENG_ID` int(11) DEFAULT NULL,
  `LTE_PCON_START` int(11) DEFAULT NULL,
  `LTE_PCON_END` int(11) DEFAULT NULL,
  `LTE_CTM` text,
  KEY `index_lte` (`LTE_TYP_ID`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `TOF_MANUFACTURERS`;
CREATE TABLE `TOF_MANUFACTURERS` (
  `MFA_ID` int(11) NOT NULL DEFAULT '0',
  `MFA_PC_MFC` text,
  `MFA_CV_MFC` text,
  `MFA_AXL_MFC` text,
  `MFA_ENG_MFC` text,
  `MFA_ENG_TYP` text,
  `MFA_MFC_CODE` text,
  `MFA_BRAND` text,
  `MFA_MF_NR` int(11) DEFAULT NULL,
  `MFA_PC_CTM` text,
  `MFA_CV_CTM` text,
  PRIMARY KEY (`MFA_ID`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `TOF_MODELS`;
CREATE TABLE `TOF_MODELS` (
  `MOD_ID` int(11) NOT NULL DEFAULT '0',
  `MOD_MFA_ID` int(11) DEFAULT NULL,
  `MOD_CDS_ID` int(11) DEFAULT NULL,
  `MOD_PCON_START` int(11) DEFAULT NULL,
  `MOD_PCON_END` int(11) DEFAULT NULL,
  `MOD_PC` text,
  `MOD_CV` text,
  `MOD_AXL` text,
  `MOD_PC_CTM` text,
  `MOD_CV_CTM` text,
  PRIMARY KEY (`MOD_ID`),
  KEY `MOD_MFA_ID` (`MOD_MFA_ID`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `TOF_SEARCH_TREE`;
CREATE TABLE `TOF_SEARCH_TREE` (
  `STR_ID` int(11) NOT NULL DEFAULT '0',
  `STR_ID_PARENT` int(11) DEFAULT NULL,
  `STR_TYPE` text,
  `STR_LEVEL` int(11) DEFAULT NULL,
  `STR_DES_ID` int(11) DEFAULT NULL,
  `STR_SORT` text,
  `STR_NODE_NR` int(11) DEFAULT NULL,
  PRIMARY KEY (`STR_ID`),
  KEY `index_str` (`STR_ID_PARENT`),
  KEY `index_str2` (`STR_LEVEL`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `TOF_SUPPLIERS`;
CREATE TABLE `TOF_SUPPLIERS` (
  `SUP_ID` int(11) NOT NULL DEFAULT '0',
  `SUP_BRAND` text,
  `SUP_SUPPLIER_NR` text,
  `SUP_COU_ID` text,
  `SUP_IS_HESS` text,
  PRIMARY KEY (`SUP_ID`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `TOF_SUPPLIERS_BLOCK`;
CREATE TABLE `TOF_SUPPLIERS_BLOCK` (
  `SBL_SUP_ID` int(11) NOT NULL,
  PRIMARY KEY (`SBL_SUP_ID`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `TOF_TYPES`;
CREATE TABLE `TOF_TYPES` (
  `TYP_ID` int(11) NOT NULL DEFAULT '0',
  `TYP_CDS_ID` int(11) DEFAULT NULL,
  `TYP_MMT_CDS_ID` int(11) DEFAULT NULL,
  `TYP_MOD_ID` int(11) DEFAULT NULL,
  `TYP_CTM` text,
  `TYP_LA_CTM` text,
  `TYP_SORT` int(11) DEFAULT NULL,
  `TYP_PCON_START` int(11) DEFAULT NULL,
  `TYP_PCON_END` int(11) DEFAULT NULL,
  `TYP_KW_FROM` int(11) DEFAULT NULL,
  `TYP_KW_UPTO` int(11) DEFAULT NULL,
  `TYP_HP_FROM` int(11) DEFAULT NULL,
  `TYP_HP_UPTO` int(11) DEFAULT NULL,
  `TYP_CCM` int(11) DEFAULT NULL,
  `TYP_CYLINDERS` int(11) DEFAULT NULL,
  `TYP_DOORS` int(11) DEFAULT NULL,
  `TYP_TANK` text,
  `TYP_KV_VOLTAGE_DES_ID` int(11) DEFAULT NULL,
  `TYP_KV_ABS_DES_ID` int(11) DEFAULT NULL,
  `TYP_KV_ASR_DES_ID` int(11) DEFAULT NULL,
  `TYP_KV_ENGINE_DES_ID` int(11) DEFAULT NULL,
  `TYP_KV_BRAKE_TYPE_DES_ID` int(11) DEFAULT NULL,
  `TYP_KV_BRAKE_SYST_DES_ID` int(11) DEFAULT NULL,
  `TYP_KV_FUEL_DES_ID` int(11) DEFAULT NULL,
  `TYP_KV_CATALYST_DES_ID` int(11) DEFAULT NULL,
  `TYP_KV_BODY_DES_ID` int(11) DEFAULT NULL,
  `TYP_KV_STEERING_DES_ID` int(11) DEFAULT NULL,
  `TYP_KV_STEERING_SIDE_DES_ID` int(11) DEFAULT NULL,
  `TYP_MAX_WEIGHT` text,
  `TYP_KV_MODEL_DES_ID` int(11) DEFAULT NULL,
  `TYP_KV_AXLE_DES_ID` int(11) DEFAULT NULL,
  `TYP_CCM_TAX` int(11) DEFAULT NULL,
  `TYP_LITRES` text,
  `TYP_KV_DRIVE_DES_ID` int(11) DEFAULT NULL,
  `TYP_KV_TRANS_DES_ID` int(11) DEFAULT NULL,
  `TYP_KV_FUEL_SUPPLY_DES_ID` int(11) DEFAULT NULL,
  `TYP_VALVES` int(11) DEFAULT NULL,
  `TYP_RT_EXISTS` text,
  PRIMARY KEY (`TYP_ID`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS TOF_IMAGE_INDEX;
CREATE TABLE `TOF_IMAGE_INDEX` (
  IIN_DLNr int,
  `IIN_FOLDER` varchar(60) NOT NULL DEFAULT '',
  `IIN_7Z` varchar(60) NOT NULL DEFAULT '',
  `IIN_NAME` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (IIN_DLNr, `IIN_FOLDER`,`IIN_7Z`,`IIN_NAME`)
);

DROP TABLE IF EXISTS TOF_ART_LOOKUP_ORIGINAL;
CREATE TABLE `TOF_ART_LOOKUP_ORIGINAL` (
  `ARL_ART_ID` int(11) DEFAULT NULL,
  `ARL_SEARCH_NUMBER` varchar(50) DEFAULT NULL,
  `ARL_KIND` int(11) DEFAULT NULL,
  `ARL_CTM` char(255) DEFAULT NULL,
  `ARL_BRA_ID` int(11) DEFAULT NULL,
  `ARL_DISPLAY_NR` varchar(50) DEFAULT NULL,
  `ARL_DISPLAY` int(11) DEFAULT NULL,
  `ARL_BLOCK` varchar(50) DEFAULT NULL,
  `ARL_SORT` int(11) DEFAULT NULL,
  KEY `index_arl` (`ARL_SEARCH_NUMBER`),
  KEY `index_arl2` (`ARL_ART_ID`)
) ENGINE=MEMORY;

DROP TABLE IF EXISTS TOF_TIPOS_ARTICULO_BTW_TD;
CREATE TABLE `TOF_TIPOS_ARTICULO_BTW_TD` (
  `TAB_TPRO_TIPO_ARTICULO` varchar(20) NOT NULL DEFAULT '',
  `TAB_GENART` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`TAB_TPRO_TIPO_ARTICULO`,`TAB_GENART`)
);

DROP TABLE IF EXISTS TOF_BRANDS_DISABLE;
CREATE TABLE `TOF_BRANDS_DISABLE` (
  `BDI_BRA_ID` int(11) NOT NULL,
  `BDI_BRA_BRAND` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`BDI_BRA_ID`)
);

#CONTINUE#alter table TOF_200 drop 200_id;
#CONTINUE#alter table TOF_200 add 200_id int auto_increment primary key FIRST;
#CONTINUE#create index index_2002 on TOF_200(ArtNr, DLNr);
#CONTINUE#create index index_iin on TOF_IMAGE_INDEX(IIN_DLNr, IIN_7Z, IIN_NAME);
#CONTINUE#create index index_030 on TOF_030(BezNr, SprachNr);
#CONTINUE#create index index_050 on TOF_050(KritNr, Typ);
#CONTINUE#create index index_052 on TOF_052(TabNr, KKey);
#CONTINUE#create index index_232 on TOF_232(BildNr);
#CONTINUE#create index index_eng on TOF_ENGINES(ENG_MFA_ID, ENG_SEARCH);
#CONTINUE#create index index_lte2 on TOF_LINK_TYP_ENG(LTE_ENG_ID);

delete from TOF_ART_LOOKUP;
insert into TOF_ART_LOOKUP (
	ARL_ART_ID
	, ARL_SEARCH_NUMBER
	, ARL_KIND
	, ARL_BRA_ID
	, ARL_DISPLAY_NR
)
select
200_id
, clean_number(ArtNr)
, 1
, b.KHerNr
, ArtNr
from TOF_200 a
LEFT JOIN TOF_001 b ON b.DLNr = a.DLNr
where a.deleted = 0;

insert into TOF_ART_LOOKUP (
	ARL_ART_ID
	, ARL_SEARCH_NUMBER
	, ARL_KIND
	, ARL_BRA_ID
	, ARL_DISPLAY_NR
)
select
200_id
, clean_number(RefNr)
, if (c.VGL = 0, 7, 2)
, KHerNr
, RefNr
from TOF_203 a, TOF_200 b, TOF_100 c
where b.ArtNr = a.ArtNr
and b.DLNr = a.DLNr
and c.HerNr = KHerNr
and a.deleted = 0;

insert into TOF_ART_LOOKUP (
	ARL_ART_ID
	, ARL_SEARCH_NUMBER
	, ARL_KIND
	, ARL_BRA_ID
	, ARL_DISPLAY_NR
)
select
200_id
, clean_number(EANNr)
, 3
, KHerNr
, EANNr
from TOF_209 a, TOF_200 b, TOF_001 c
where b.ArtNr = a.ArtNr
and b.DLNr = a.DLNr
and c.DLNr = b.DLNr
and a.deleted = 0;

insert into TOF_ART_LOOKUP (
	ARL_ART_ID
	, ARL_SEARCH_NUMBER
	, ARL_KIND
	, ARL_BRA_ID
	, ARL_DISPLAY_NR
)
select
200_id
, clean_number(ErsatzNr)
, 4
, KHerNr
, ErsatzNr
from TOF_204 a, TOF_200 b, TOF_001 c
where b.ArtNr = a.ArtNr
and b.DLNr = a.DLNr
and c.DLNr = b.DLNr
and a.deleted = 0
;

insert into TOF_ART_LOOKUP (
	ARL_ART_ID
	, ARL_SEARCH_NUMBER
	, ARL_KIND
	, ARL_BRA_ID
	, ARL_DISPLAY_NR
)
select
200_id
, clean_number(PartNr)
, 5
, KHerNr
, PartNr
from TOF_205 a, TOF_200 b, TOF_001 c
where b.ArtNr = a.ArtNr
and b.DLNr = a.DLNr
and c.DLNr = b.DLNr
and a.deleted = 0
;

insert into TOF_ART_LOOKUP (
	ARL_ART_ID
	, ARL_SEARCH_NUMBER
	, ARL_KIND
	, ARL_BRA_ID
	, ARL_DISPLAY_NR
)
select
200_id
, clean_number(GebrNr)
, 6
, KHerNr
, GebrNr
from TOF_207 a, TOF_200 b, TOF_001 c
where b.ArtNr = a.ArtNr
and b.DLNr = a.DLNr
and c.DLNr = b.DLNr
and a.deleted = 0;

create index index_arl1 on TOF_ART_LOOKUP(ARL_SEARCH_NUMBER, ARL_KIND);
create index index_arl2 on TOF_ART_LOOKUP(ARL_ART_ID);

delete from TOF_MANUFACTURERS;

insert into TOF_MANUFACTURERS (
	MFA_ID
	, MFA_BRAND
)
select HerNr, Bez from TOF_100 a, TOF_012 b
where PKW = 1
and b.LBezNr = a.LBezNr
and b.SprachNr = 8;

delete from TOF_COUNTRY_DESIGNATIONS;

insert into TOF_COUNTRY_DESIGNATIONS (
	CDS_ID
	, CDS_LNG_ID
	, TEX_TEXT
)
select
LBezNr, SprachNr, Bez
from TOF_012;

DELETE FROM TOF_MODELS;
insert into TOF_MODELS (
	MOD_ID
	, MOD_MFA_ID
	, MOD_CDS_ID
	, MOD_PCON_START
	, MOD_PCON_END
)
select 
distinct KModNr
, HerNr
, LBezNr
, Bjvon
, BJBis
from TOF_110 group by 1;

update TOF_MODELS set MOD_PCON_END = NULL
where MOD_PCON_END = 0;

DELETE FROM TOF_TYPES;
insert into TOF_TYPES (
	TYP_ID
	, TYP_CDS_ID
	, TYP_MMT_CDS_ID
	, TYP_MOD_ID
	, TYP_PCON_START
	, TYP_PCON_END
	, TYP_KW_FROM
	, TYP_HP_FROM
	, TYP_LITRES
	, TYP_CYLINDERS
	, TYP_DOORS
	, TYP_TANK
	, TYP_VALVES
	, TYP_KV_BODY_DES_ID
	, TYP_KV_DRIVE_DES_ID
)
select 
distinct KTypNr
, LBezNr
, LBezNr
, KModNr
, Bjvon
, Bjbis
, KW
, PS
, Lit
, Zyl
, Tueren
, TankInhalt
, Ventile
, b.BezNr
, c.BezNr
from TOF_120 a
LEFT JOIN TOF_052 b ON b.TabNr = 86
AND b.Kkey = a.AufbauArt
LEFT JOIN TOF_052 c ON c.TabNr = 82
AND c.Kkey = a.AntrArt;

update TOF_TYPES
set TYP_PCON_END = NULL
where TYP_PCON_END = 0;

delete from TOF_LINK_TYP_ENG;
insert into TOF_LINK_TYP_ENG (
	LTE_TYP_ID
	, LTE_NR
	, LTE_ENG_ID
	, LTE_PCON_START
	, LTE_PCON_END
)
select
KTypNr
, LfdNr
, MotNr
, Bjvon
, Bjbis
from TOF_125;

delete from TOF_ENGINES;
insert into TOF_ENGINES (
	ENG_ID
	, ENG_MFA_ID
	, ENG_CODE
	, ENG_VALVES
	, ENG_CYLINDERS
	, ENG_LITRES_FROM
  , ENG_CODE
)
select
  MotNr
, HerNr
, MCode
, Ventile
, Zyl
, LitTechV
, clean_number(MCode)
from TOF_155;

delete from TOF_DESIGNATIONS;
insert into TOF_DESIGNATIONS (
	DES_ID
	, DES_LNG_ID
	, TEX_TEXT
)
select
BezNr
, SprachNr
, Bez
from TOF_030;

delete from TOF_ARTICLES;
insert into TOF_ARTICLES (
	ART_ID
	, ART_ARTICLE_NR
	, ART_SUP_ID
	, ART_DES_ID
	, ART_COMPLETE_DES_ID
	, ART_PACK_SELFSERVICE
	, ART_MATERIAL_MARK
	, ART_REPLACEMENT
	, ART_ACCESSORY
)
select 
200_id
, a.ArtNr
, a.DLNr
, a.BezNr
, c.BezNr
, KZSB
, KZMat
, KZAT
, KZZub
from 
TOF_200 a
, TOF_211 b
, TOF_320 c
where b.ArtNr = a.ArtNr
and b.DLNr = a.DLNr
and c.GenArtNr = b.GenArtNr
group by 1;

delete from TOF_SEARCH_TREE;
insert into TOF_SEARCH_TREE (
	STR_ID
	, STR_ID_PARENT
	, STR_TYPE
	, STR_LEVEL
	, STR_DES_ID
)
select 
Node_ID
, Node_Parent_ID
, TreeTypNr
, Stufe
, BezNr
from TOF_301;

delete from TOF_LINK_GA_STR;
insert into TOF_LINK_GA_STR (
	LGS_STR_ID
	, LGS_GA_ID
)
select 
Node_ID
, GenArtNr
from TOF_302;

delete from TOF_LINK_ART;
insert into TOF_LINK_ART (
	LA_ART_ID
	, LA_GA_ID
)
select 
200_id, 
GenArtNr
from TOF_200 a
, TOF_211 b
where b.ArtNr = a.ArtNr
and b.DLNr = a.DLNr;

delete from TOF_LANGUAGES;
insert into TOF_LANGUAGES (
	LNG_ID
	, LNG_DES_ID
)
select SprachNr, BezNr
from TOF_020;

delete from TOF_BRANDS;
insert into TOF_BRANDS (
	BRA_ID
	, BRA_BRAND
)
select HerNr, Bez 
from TOF_100 a
, TOF_012 b
where a.LBezNr = b.LBezNr
and b.SprachNr = 8;

delete from TOF_SUPPLIERS;
insert into TOF_SUPPLIERS (
	SUP_ID
	, SUP_BRAND
)
select 
DLNr, Marke
from TOF_001;

insert into TOF_SUPPLIERS(SUP_ID, SUP_BRAND)
values(-1, "BTW HOLDING"),
(-2, "BTW HOLDING");

insert into TOF_BRANDS(BRA_ID, BRA_BRAND)
values(-1, "BTW HOLDING"),
(-2, "BTW HOLDING");

delete from TOF_ARTICLE_IMAGES;
insert into TOF_ARTICLE_IMAGES (
	article_id,
  image,
  file_type,
  folder
)
select 
200_id
, Bildname
, b.DokumentenArt
, LPAD(SUBSTR(a.BildNr, 1, LENGTH(a.BildNr) - 5), 4, '0')
from TOF_232 a,
TOF_231 b,
TOF_200 c
where
b.BildNr = a.BildNr
and b.BildType = 1
and b.DLNr = a.DLNr
and c.ArtNr = a.ArtNr
and c.DLNr = a.DLNr;