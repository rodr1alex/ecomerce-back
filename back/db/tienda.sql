-- MySQL dump 10.13  Distrib 8.0.37, for Linux (x86_64)
--
-- Host: localhost    Database: tienda
-- ------------------------------------------------------
-- Server version	8.0.37-0ubuntu0.24.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `banner_images`
--

DROP TABLE IF EXISTS `banner_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banner_images` (
  `banner_image_id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(500) DEFAULT NULL,
  `mobile` tinyint DEFAULT NULL,
  PRIMARY KEY (`banner_image_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner_images`
--

LOCK TABLES `banner_images` WRITE;
/*!40000 ALTER TABLE `banner_images` DISABLE KEYS */;
INSERT INTO `banner_images` VALUES (1,'https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/013bec61986743.5a8112dadc9ca.jpg',0),(2,'https://img.freepik.com/free-psd/banner-template-online-sports-sale_23-2148561287.jpg',0),(3,'https://www.shutterstock.com/image-photo/overhead-view-different-sports-equipment-260nw-1548966812.jpg',0);
/*!40000 ALTER TABLE `banner_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `base_product_images`
--

DROP TABLE IF EXISTS `base_product_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `base_product_images` (
  `base_product_image_id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(1000) DEFAULT NULL,
  `base_product_id` int DEFAULT NULL,
  PRIMARY KEY (`base_product_image_id`),
  KEY `fk_base_product_images_1_idx` (`base_product_id`),
  CONSTRAINT `fk_base_product_images_1` FOREIGN KEY (`base_product_id`) REFERENCES `base_products` (`base_product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_product_images`
--

LOCK TABLES `base_product_images` WRITE;
/*!40000 ALTER TABLE `base_product_images` DISABLE KEYS */;
INSERT INTO `base_product_images` VALUES (1,'https://sparta.cl/media/catalog/product/z/a/zapatillas-running-mujer-nike-downshifter-13-blanca-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',NULL),(2,'https://sparta.cl/media/catalog/product/z/a/zapatillas-running-mujer-nike-downshifter-13-blanca-superior.png?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',NULL),(3,'https://sparta.cl/media/catalog/product/z/a/zapatillas-running-mujer-nike-downshifter-13-blanca-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',1),(4,'https://sparta.cl/media/catalog/product/z/a/zapatillas-running-mujer-nike-downshifter-13-blanca-superior.png?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',1),(5,'https://sparta.cl/media/catalog/product/z/a/zapatillas-running-hombre-adidas-duramo-sl-negra-lateral.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',NULL),(6,'https://sparta.cl/media/catalog/product/z/a/zapatillas-running-hombre-adidas-duramo-sl-negra-inferior.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',NULL),(9,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-1080-v13-azul-marino-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',3),(10,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-880-v14-negra-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',4),(11,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2259ad072e1148fe92b04fe92d1a20d8_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Blanco_IG6441_HM3_hover.jpg',5),(12,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/0f3c3eff8b2e4037915c49032c017eda_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Blanco_IG6441_HM4.jpg',5),(13,'https://assets.adidas.com/images/h_2000,f_auto,q_auto,fl_lossy,c_fill,g_auto/87176ee576f24357b3843634a1e5d5bb_9366/Zapatillas_Adizero_Boston_12_Negro_HQ2171_HM1.jpg',6),(14,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-evoz-v3-negra-lateral_2.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',7),(15,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-evoz-v3-negra-lateral-interior_2.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',7);
/*!40000 ALTER TABLE `base_product_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `base_products`
--

DROP TABLE IF EXISTS `base_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `base_products` (
  `base_product_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `base_price` int DEFAULT NULL,
  `chars` varchar(3000) DEFAULT NULL,
  `specs` varchar(3000) DEFAULT NULL,
  `brand_id` int DEFAULT NULL,
  PRIMARY KEY (`base_product_id`),
  KEY `fk_base_products_1_idx` (`brand_id`),
  CONSTRAINT `fk_base_products_1` FOREIGN KEY (`brand_id`) REFERENCES `brands` (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_products`
--

LOCK TABLES `base_products` WRITE;
/*!40000 ALTER TABLE `base_products` DISABLE KEYS */;
INSERT INTO `base_products` VALUES (1,'Zapatillas Running Mujer Downshifter 13','Ya sea que estés comenzando tu recorrido como corredor o seas un experto deseando cambiar tu ritmo, el Downshifter 13 está listo para acompañarte.',62990,'\n\nYa sea que estés comenzando tu recorrido como corredor o seas un experto deseando cambiar tu ritmo, el Downshifter 13 está listo para acompañarte. Con una parte superior renovada, amortiguación y durabilidad, te ayuda a encontrar ese impulso adicional o dar el primer paso hacia la consecución de tus objetivos.','    Hecho con Nike Grind\n    Malla Transpirable\n    Apoyo y seguridad\n',1),(3,'Zapatillas Running Hombre 1080 V13 ','Zapatilla Runing para entisiastas del deporte, hasta 21k',149990,'El modelo 1080 es la oferta cumbre de la línea de running de New Balance. Una combinación de tecnología de rendimiento de primera calidad y accesibilidad de amplio alcance ofrece a los corredores de todos los niveles de intensidad más comodidad en distancias más largas. En pocas palabras, no hay otro calzado como el 1080. El Fresh Foam X 1080v13 representa una progresión constante de las cualidades distintivas del modelo. Las transiciones suaves de la experiencia máxima de amortiguación bajo los pies se ajustan con','Mediasuela Fresh Foam X con aproximadamente un 3% de contenido biodegradable que brinda nuestra experiencia Fresh Foam más amortiguada para una comodidad increíble. El contenido biodegradable está hecho de recursos renovables para ayudar a reducir nuestra huella de carbono.\n\nTecnología de suela de goma NDurance que proporciona una durabilidad superior en áreas de alto desgaste para aprovechar al máximo el calzado.\n\nParte superior de malla de aire diseñada',3),(4,'Zapatillas Running Mujer 880 v14','Zapatilla Runing para quienes disfrutan de la actividad al aire libre',99990,'Descubre la fusión perfecta entre tecnología avanzada y comodidad suprema con las zapatillas de running New Balance 880 v14. Diseñadas para impulsar tu rendimiento a nuevas alturas, estas zapatillas ofrecen una amortiguación responsiva que absorbe el impacto en cada zancada, proporcionando una sensación de suavidad y agilidad. La parte superior de malla transpirable brinda un ajuste cómodo y ventilado, manteniendo tus pies frescos durante toda la carrera. La estructura ligera y el soporte estratégico trabajan juntos para ofrecer estabilidad sin sacrificar la flexibilidad, permitiéndote moverte con confianza y fluidez en cada paso. La tecnología de entresuela FuelCell proporciona una respuesta rápida y una sensación de impulso, impulsándote hacia adelante con energía renovada. Ya sea que estés entrenando para una competición o disfrutando de un trote diario, las New Balance 880 v14 son la elección perfecta para los corredores que buscan un equilibrio perfecto entre rendimiento y confort. ¡Desata tu potencial con cada carrera!','Drop de 8 mm**\n\n Fresh Foam X con Bio Eva\n\n    Sintético/malla\n\n    Ajuste con Cordones\n\n    Peso: 7.4 oz | 209 g\n',3),(5,'Zapatillas ADIZERO ADIOS PRO 3','Zapatilla Runing para entisiastas del deporte, alto rendimiento y comodidad',229990,'Las Adizero Adios Pro 3 son la máxima expresión de los productos Adizero Racing. Fueron diseñadas con y para atletas para lograr hazañas increíbles. Estas zapatillas de running adidas están diseñadas para optimizar la eficiencia del running. Nuestras varillas ENERGYRODS 2.0 de carbono ofrecen ligereza y firmeza para pasos ágiles y eficientes. La tecnología LIGHTSTRIKE PRO ultraliviana amortigua cada paso con las tres capas de espuma resistente que te ayudan a mantener la energía a largo plazo. Todo sobre una delgada suela de caucho textil para un agarre extraordinario en condiciones mojadas y secas.','    Corte clásico\n    Parte superior sintética\n    Forro interno textil\n    Varillas ENERGYRODS 2.0 que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n    Peso: 223 gramos (talla CHI 40,5)\n    Caída mediasuela: 6 mm (talón: 40 mm / antepié: 34 mm)\n    La parte superior contiene al menos un 50% de material reciclado\n    Color del artículo: Crystal White / Lucid Lemon / Blue Burst\n    Número de artículo: IG6441',2),(6,'Zapatillas Adizero Boston 12','Zapatilla de gran comodidad y versatilidad',149990,'La Maratón de Boston® es una carrera. Pero también es un objetivo, un plan de entrenamiento y está en tu mente todos los días antes del gran reto. Las zapatillas Adizero Boston 12 están diseñadas para correr distancias medias y largas. Inyectan una sensación de propulsión a cada entrenamiento con la infusión de fibra de vidrio con las varillas ENERGYRODS 2.0, que limitan la pérdida de energía bajo el pie. Son rápidas, pero esto no se consigue a expensas de la durabilidad. La mediasuela combina la amortiguación Lightstrike Pro ultraliviana con la nueva versión de la tecnología LIGHTSTRIKE 2.0 EVA resistente','    Ajuste clásico\n    Sistema de atado de cordones\n    Exterior liviano de malla\n    Forro interno textil\n    Varillas ENERGYRODS que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n\n    Peso: 227 g (Talle AR 37,5)\n    Caída mediasuela: 7 mm (talón: 19 mm / antepié: 12 mm) 38 mm / antepié: 31 mm)\n    Suela de caucho Continental™ Rubber\n    El exterior contiene al menos un 50% de material reciclado\n    Color del artículo: Core Black / Cloud White / Carbon',2),(7,'Zapatillas Running Mujer Evoz V3 ','Zapatilla Runing para entisiastas del deporte',69990,'Experimente la mejor comodidad de su clase con New Balance Fresh Foam X EVOZ v3. Ahora con Fresh Foam X, este zapato suave y lujoso equilibra la innovación comprobada con comodidad y soporte accesibles durante todo el día. Combinado con una parte superior de malla de ingeniería liviana para una transpirabilidad y elasticidad impresionantes, esta zapatilla para correr de primera calidad está diseñada para ser su entrenador diario.','a entresuela Fresh Foam X ofrece nuestra experiencia Fresh Foam más acolchada para una comodidad increíble\n\nLa parte superior presenta una construcción sin costuras para un ajuste y una sensación elegantes\n\nParte superior de tela suave y malla diseñada\n\nSuela de goma integrada\n\nCierre de cordones ajustable para un ajuste personalizado\n\nDrop de 8 mm**\n',3);
/*!40000 ALTER TABLE `base_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `base_products_categories`
--

DROP TABLE IF EXISTS `base_products_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `base_products_categories` (
  `base_product_id` int NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`base_product_id`,`category_id`),
  KEY `fk_category_idx` (`category_id`),
  CONSTRAINT `fk_base_product` FOREIGN KEY (`base_product_id`) REFERENCES `base_products` (`base_product_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_products_categories`
--

LOCK TABLES `base_products_categories` WRITE;
/*!40000 ALTER TABLE `base_products_categories` DISABLE KEYS */;
INSERT INTO `base_products_categories` VALUES (1,1),(3,1),(4,1),(5,1),(6,1),(7,1),(1,7),(3,7),(4,7),(5,7),(6,7),(7,7),(3,10),(5,10),(1,11),(4,11),(6,11),(7,11);
/*!40000 ALTER TABLE `base_products_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brands`
--

DROP TABLE IF EXISTS `brands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brands` (
  `brand_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brands`
--

LOCK TABLES `brands` WRITE;
/*!40000 ALTER TABLE `brands` DISABLE KEYS */;
INSERT INTO `brands` VALUES (1,'Nike'),(2,'Adidas'),(3,'New Balance'),(4,'');
/*!40000 ALTER TABLE `brands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carts`
--

DROP TABLE IF EXISTS `carts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carts` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `total` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `sale_id` int DEFAULT NULL,
  `items` int DEFAULT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `fk_user_idx` (`user_id`),
  KEY `fk_sale_idx` (`sale_id`),
  CONSTRAINT `fk_sale` FOREIGN KEY (`sale_id`) REFERENCES `sales` (`sale_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carts`
--

LOCK TABLES `carts` WRITE;
/*!40000 ALTER TABLE `carts` DISABLE KEYS */;
INSERT INTO `carts` VALUES (1,0,1,2,0),(2,62990,2,1,1),(3,399970,1,3,3),(4,NULL,1,NULL,NULL);
/*!40000 ALTER TABLE `carts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carts_ordered_product_list`
--

DROP TABLE IF EXISTS `carts_ordered_product_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carts_ordered_product_list` (
  `cart_cart_id` int NOT NULL,
  `ordered_product_list_ordered_product_id` int NOT NULL,
  UNIQUE KEY `ordered_product_id_asdfasd_UNIQUE` (`ordered_product_list_ordered_product_id`),
  KEY `asdfsadf_idx` (`cart_cart_id`),
  KEY `asdsa_idx` (`ordered_product_list_ordered_product_id`),
  CONSTRAINT `asdfsadf` FOREIGN KEY (`cart_cart_id`) REFERENCES `carts` (`cart_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `asdsa` FOREIGN KEY (`ordered_product_list_ordered_product_id`) REFERENCES `ordered_products` (`ordered_product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carts_ordered_product_list`
--

LOCK TABLES `carts_ordered_product_list` WRITE;
/*!40000 ALTER TABLE `carts_ordered_product_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `carts_ordered_product_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Running'),(2,'Ciclismo'),(3,'Natacion'),(4,'Accesorio'),(5,'Bicicletas'),(6,'Ropa'),(7,'Calzado'),(8,'Elementos de proteccion'),(9,'Trajes de neopreno'),(10,'Hombre'),(11,'Mujer'),(12,'Ninio'),(13,'Nutricion'),(14,'Unisex');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color_variant_product_images`
--

DROP TABLE IF EXISTS `color_variant_product_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `color_variant_product_images` (
  `color_variant_product_image_id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(1000) DEFAULT NULL,
  `color_variant_product_id` int DEFAULT NULL,
  PRIMARY KEY (`color_variant_product_image_id`),
  KEY `fk_color_variant_product_images_1_idx` (`color_variant_product_id`),
  CONSTRAINT `fk_color_variant_product_images_1` FOREIGN KEY (`color_variant_product_id`) REFERENCES `color_variant_products` (`color_variant_product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color_variant_product_images`
--

LOCK TABLES `color_variant_product_images` WRITE;
/*!40000 ALTER TABLE `color_variant_product_images` DISABLE KEYS */;
INSERT INTO `color_variant_product_images` VALUES (1,'https://sparta.cl/media/catalog/product/z/a/zapatillas-running-mujer-nike-downshifter-13-blanca-lateral-interior.png?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',1),(6,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-1080-v13-azul-marino-superior.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',4),(7,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-fresh-foam-x-vongo-v6-negra-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',5),(8,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-880-v14-azul-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',6),(9,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-880-v14-negra-superior.png?quality=80&bg-color=255,255,255&fit=bounds&height=90&width=90&canvas=90:90',7),(10,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2a35abb799174437a80d99e2e8958b1c_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Verde_IG6445_HM3_hover.jpg',9),(11,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2b613a79d46d43af859cf9dfc86318d4_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Negro_IG6439_HM5.jpg',8),(12,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/cda54fcc501e4e76ad7b338dea111591_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Verde_IG6445_HM4.jpg',9),(13,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/a2f4b3fcc7014f67bbcbb53c3ee26d3a_9366/Zapatillas_Adizero_Boston_12_Turquesa_ID6901_HM1.jpg',11),(14,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/9830b8efb0fe46bea873a7c8f1f765db_9366/Zapatillas_Adizero_Boston_12_Beige_IG3325_HM1.jpg',10),(15,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/af042b42376e4f6ba3d83eacbf5e15d6_9366/Zapatillas_Adizero_Boston_12_Turquesa_ID6901_HM3_hover.jpg',11),(16,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-evoz-v3-negra-superior_2.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',12);
/*!40000 ALTER TABLE `color_variant_product_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color_variant_products`
--

DROP TABLE IF EXISTS `color_variant_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `color_variant_products` (
  `color_variant_product_id` int NOT NULL AUTO_INCREMENT,
  `base_product_id` int DEFAULT NULL,
  `color_id` int DEFAULT NULL,
  PRIMARY KEY (`color_variant_product_id`),
  KEY `fk_color_variant_products_1_idx` (`color_id`),
  KEY `fk_color_variant_products_2_idx` (`base_product_id`),
  CONSTRAINT `fk_color_variant_products_1` FOREIGN KEY (`color_id`) REFERENCES `colors` (`color_id`),
  CONSTRAINT `fk_color_variant_products_2` FOREIGN KEY (`base_product_id`) REFERENCES `base_products` (`base_product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color_variant_products`
--

LOCK TABLES `color_variant_products` WRITE;
/*!40000 ALTER TABLE `color_variant_products` DISABLE KEYS */;
INSERT INTO `color_variant_products` VALUES (1,1,2),(4,3,4),(5,3,3),(6,4,4),(7,4,4),(8,5,3),(9,5,5),(10,6,7),(11,6,5),(12,7,3);
/*!40000 ALTER TABLE `color_variant_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colors`
--

DROP TABLE IF EXISTS `colors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colors` (
  `color_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `tailwindclass` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`color_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colors`
--

LOCK TABLES `colors` WRITE;
/*!40000 ALTER TABLE `colors` DISABLE KEYS */;
INSERT INTO `colors` VALUES (1,'NoColor',''),(2,'Blanco','nm-flat-white'),(3,'Negro','nm-flat-blue-900'),(4,'Azul','nm-flat-blue-100'),(5,'Verde','nm-flat-green-100'),(6,'Rojo','nm-flat-red-100'),(7,'Rosado','nm-flat-blue-100'),(8,'Amarillo','nm-flat-yellow-100'),(9,'',NULL);
/*!40000 ALTER TABLE `colors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `directions`
--

DROP TABLE IF EXISTS `directions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `directions` (
  `direction_id` int NOT NULL AUTO_INCREMENT,
  `city` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `number` varchar(45) DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`direction_id`),
  KEY `fk_user_idx` (`user_id`),
  CONSTRAINT `asefqweafe` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directions`
--

LOCK TABLES `directions` WRITE;
/*!40000 ALTER TABLE `directions` DISABLE KEYS */;
INSERT INTO `directions` VALUES (1,'Temuco','Pratt','1232',2),(2,'Temuco','Rodrigues','123423',1);
/*!40000 ALTER TABLE `directions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `final_products`
--

DROP TABLE IF EXISTS `final_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `final_products` (
  `final_product_id` int NOT NULL AUTO_INCREMENT,
  `stock` int DEFAULT NULL,
  `final_price` int DEFAULT NULL,
  `final_description` varchar(1000) DEFAULT NULL,
  `final_chars` varchar(3000) DEFAULT NULL,
  `final_specs` varchar(3000) DEFAULT NULL,
  `color_variant_product_id` int DEFAULT NULL,
  `size_id` int DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `color` varchar(100) DEFAULT NULL,
  `img` varchar(1000) DEFAULT NULL,
  `base_product_id` int DEFAULT NULL,
  `name` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`final_product_id`),
  KEY `fk_final_products_1_idx` (`size_id`),
  KEY `fk_final_products_2_idx` (`color_variant_product_id`),
  CONSTRAINT `fk_final_products_1` FOREIGN KEY (`size_id`) REFERENCES `sizes` (`size_id`),
  CONSTRAINT `fk_final_products_2` FOREIGN KEY (`color_variant_product_id`) REFERENCES `color_variant_products` (`color_variant_product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `final_products`
--

LOCK TABLES `final_products` WRITE;
/*!40000 ALTER TABLE `final_products` DISABLE KEYS */;
INSERT INTO `final_products` VALUES (1,99,62990,'Ya sea que estés comenzando tu recorrido como corredor o seas un experto deseando cambiar tu ritmo, el Downshifter 13 está listo para acompañarte.','\n\nYa sea que estés comenzando tu recorrido como corredor o seas un experto deseando cambiar tu ritmo, el Downshifter 13 está listo para acompañarte. Con una parte superior renovada, amortiguación y durabilidad, te ayuda a encontrar ese impulso adicional o dar el primer paso hacia la consecución de tus objetivos.','    Hecho con Nike Grind\n    Malla Transpirable\n    Apoyo y seguridad\n',1,44,'Nike','Blanco','https://sparta.cl/media/catalog/product/z/a/zapatillas-running-mujer-nike-downshifter-13-blanca-lateral-interior.png?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',1,'Zapatillas Running Mujer Downshifter 13'),(2,98,149990,'Zapatilla Runing para entisiastas del deporte, hasta 21k','El modelo 1080 es la oferta cumbre de la línea de running de New Balance. Una combinación de tecnología de rendimiento de primera calidad y accesibilidad de amplio alcance ofrece a los corredores de todos los niveles de intensidad más comodidad en distancias más largas. En pocas palabras, no hay otro calzado como el 1080. El Fresh Foam X 1080v13 representa una progresión constante de las cualidades distintivas del modelo. Las transiciones suaves de la experiencia máxima de amortiguación bajo los pies se ajustan con','Mediasuela Fresh Foam X con aproximadamente un 3% de contenido biodegradable que brinda nuestra experiencia Fresh Foam más amortiguada para una comodidad increíble. El contenido biodegradable está hecho de recursos renovables para ayudar a reducir nuestra huella de carbono.\n\nTecnología de suela de goma NDurance que proporciona una durabilidad superior en áreas de alto desgaste para aprovechar al máximo el calzado.\n\nParte superior de malla de aire diseñada',4,49,'New Balance','Azul','https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-1080-v13-azul-marino-superior.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',3,'Zapatillas Running Hombre 1080 V13 '),(3,50,149990,'Zapatilla Runing para entisiastas del deporte, hasta 21k','El modelo 1080 es la oferta cumbre de la línea de running de New Balance. Una combinación de tecnología de rendimiento de primera calidad y accesibilidad de amplio alcance ofrece a los corredores de todos los niveles de intensidad más comodidad en distancias más largas. En pocas palabras, no hay otro calzado como el 1080. El Fresh Foam X 1080v13 representa una progresión constante de las cualidades distintivas del modelo. Las transiciones suaves de la experiencia máxima de amortiguación bajo los pies se ajustan con','Mediasuela Fresh Foam X con aproximadamente un 3% de contenido biodegradable que brinda nuestra experiencia Fresh Foam más amortiguada para una comodidad increíble. El contenido biodegradable está hecho de recursos renovables para ayudar a reducir nuestra huella de carbono.\n\nTecnología de suela de goma NDurance que proporciona una durabilidad superior en áreas de alto desgaste para aprovechar al máximo el calzado.\n\nParte superior de malla de aire diseñada',4,50,'New Balance','Azul','https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-1080-v13-azul-marino-superior.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',3,'Zapatillas Running Hombre 1080 V13 '),(4,79,149990,'Zapatilla Runing para entisiastas del deporte, hasta 21k','El modelo 1080 es la oferta cumbre de la línea de running de New Balance. Una combinación de tecnología de rendimiento de primera calidad y accesibilidad de amplio alcance ofrece a los corredores de todos los niveles de intensidad más comodidad en distancias más largas. En pocas palabras, no hay otro calzado como el 1080. El Fresh Foam X 1080v13 representa una progresión constante de las cualidades distintivas del modelo. Las transiciones suaves de la experiencia máxima de amortiguación bajo los pies se ajustan con','Mediasuela Fresh Foam X con aproximadamente un 3% de contenido biodegradable que brinda nuestra experiencia Fresh Foam más amortiguada para una comodidad increíble. El contenido biodegradable está hecho de recursos renovables para ayudar a reducir nuestra huella de carbono.\n\nTecnología de suela de goma NDurance que proporciona una durabilidad superior en áreas de alto desgaste para aprovechar al máximo el calzado.\n\nParte superior de malla de aire diseñada',5,44,'New Balance','Negro','https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-fresh-foam-x-vongo-v6-negra-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',3,'Zapatillas Running Hombre 1080 V13 '),(5,99,99990,'Zapatilla Runing para quienes disfrutan de la actividad al aire libre','Descubre la fusión perfecta entre tecnología avanzada y comodidad suprema con las zapatillas de running New Balance 880 v14. Diseñadas para impulsar tu rendimiento a nuevas alturas, estas zapatillas ofrecen una amortiguación responsiva que absorbe el impacto en cada zancada, proporcionando una sensación de suavidad y agilidad. La parte superior de malla transpirable brinda un ajuste cómodo y ventilado, manteniendo tus pies frescos durante toda la carrera. La estructura ligera y el soporte estratégico trabajan juntos para ofrecer estabilidad sin sacrificar la flexibilidad, permitiéndote moverte con confianza y fluidez en cada paso. La tecnología de entresuela FuelCell proporciona una respuesta rápida y una sensación de impulso, impulsándote hacia adelante con energía renovada. Ya sea que estés entrenando para una competición o disfrutando de un trote diario, las New Balance 880 v14 son la elección perfecta para los corredores que buscan un equilibrio perfecto entre rendimiento y confort. ¡Desata tu potencial con cada carrera!','Drop de 8 mm**\n\n Fresh Foam X con Bio Eva\n\n    Sintético/malla\n\n    Ajuste con Cordones\n\n    Peso: 7.4 oz | 209 g\n',6,43,'New Balance','Azul','https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-880-v14-azul-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',4,'Zapatillas Running Mujer 880 v14'),(6,100,99990,'Zapatilla Runing para quienes disfrutan de la actividad al aire libre','Descubre la fusión perfecta entre tecnología avanzada y comodidad suprema con las zapatillas de running New Balance 880 v14. Diseñadas para impulsar tu rendimiento a nuevas alturas, estas zapatillas ofrecen una amortiguación responsiva que absorbe el impacto en cada zancada, proporcionando una sensación de suavidad y agilidad. La parte superior de malla transpirable brinda un ajuste cómodo y ventilado, manteniendo tus pies frescos durante toda la carrera. La estructura ligera y el soporte estratégico trabajan juntos para ofrecer estabilidad sin sacrificar la flexibilidad, permitiéndote moverte con confianza y fluidez en cada paso. La tecnología de entresuela FuelCell proporciona una respuesta rápida y una sensación de impulso, impulsándote hacia adelante con energía renovada. Ya sea que estés entrenando para una competición o disfrutando de un trote diario, las New Balance 880 v14 son la elección perfecta para los corredores que buscan un equilibrio perfecto entre rendimiento y confort. ¡Desata tu potencial con cada carrera!','Drop de 8 mm**\n\n Fresh Foam X con Bio Eva\n\n    Sintético/malla\n\n    Ajuste con Cordones\n\n    Peso: 7.4 oz | 209 g\n',6,42,'New Balance','Azul','https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-880-v14-azul-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',4,'Zapatillas Running Mujer 880 v14'),(7,99,99990,'Zapatilla Runing para quienes disfrutan de la actividad al aire libre','Descubre la fusión perfecta entre tecnología avanzada y comodidad suprema con las zapatillas de running New Balance 880 v14. Diseñadas para impulsar tu rendimiento a nuevas alturas, estas zapatillas ofrecen una amortiguación responsiva que absorbe el impacto en cada zancada, proporcionando una sensación de suavidad y agilidad. La parte superior de malla transpirable brinda un ajuste cómodo y ventilado, manteniendo tus pies frescos durante toda la carrera. La estructura ligera y el soporte estratégico trabajan juntos para ofrecer estabilidad sin sacrificar la flexibilidad, permitiéndote moverte con confianza y fluidez en cada paso. La tecnología de entresuela FuelCell proporciona una respuesta rápida y una sensación de impulso, impulsándote hacia adelante con energía renovada. Ya sea que estés entrenando para una competición o disfrutando de un trote diario, las New Balance 880 v14 son la elección perfecta para los corredores que buscan un equilibrio perfecto entre rendimiento y confort. ¡Desata tu potencial con cada carrera!','Drop de 8 mm**\n\n Fresh Foam X con Bio Eva\n\n    Sintético/malla\n\n    Ajuste con Cordones\n\n    Peso: 7.4 oz | 209 g\n',6,44,'New Balance','Azul','https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-880-v14-azul-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',4,'Zapatillas Running Mujer 880 v14'),(8,100,99990,'Zapatilla Runing para quienes disfrutan de la actividad al aire libre','Descubre la fusión perfecta entre tecnología avanzada y comodidad suprema con las zapatillas de running New Balance 880 v14. Diseñadas para impulsar tu rendimiento a nuevas alturas, estas zapatillas ofrecen una amortiguación responsiva que absorbe el impacto en cada zancada, proporcionando una sensación de suavidad y agilidad. La parte superior de malla transpirable brinda un ajuste cómodo y ventilado, manteniendo tus pies frescos durante toda la carrera. La estructura ligera y el soporte estratégico trabajan juntos para ofrecer estabilidad sin sacrificar la flexibilidad, permitiéndote moverte con confianza y fluidez en cada paso. La tecnología de entresuela FuelCell proporciona una respuesta rápida y una sensación de impulso, impulsándote hacia adelante con energía renovada. Ya sea que estés entrenando para una competición o disfrutando de un trote diario, las New Balance 880 v14 son la elección perfecta para los corredores que buscan un equilibrio perfecto entre rendimiento y confort. ¡Desata tu potencial con cada carrera!','Drop de 8 mm**\n\n Fresh Foam X con Bio Eva\n\n    Sintético/malla\n\n    Ajuste con Cordones\n\n    Peso: 7.4 oz | 209 g\n',6,45,'New Balance','Azul','https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-880-v14-azul-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',4,'Zapatillas Running Mujer 880 v14'),(9,100,99990,'Zapatilla Runing para quienes disfrutan de la actividad al aire libre','Descubre la fusión perfecta entre tecnología avanzada y comodidad suprema con las zapatillas de running New Balance 880 v14. Diseñadas para impulsar tu rendimiento a nuevas alturas, estas zapatillas ofrecen una amortiguación responsiva que absorbe el impacto en cada zancada, proporcionando una sensación de suavidad y agilidad. La parte superior de malla transpirable brinda un ajuste cómodo y ventilado, manteniendo tus pies frescos durante toda la carrera. La estructura ligera y el soporte estratégico trabajan juntos para ofrecer estabilidad sin sacrificar la flexibilidad, permitiéndote moverte con confianza y fluidez en cada paso. La tecnología de entresuela FuelCell proporciona una respuesta rápida y una sensación de impulso, impulsándote hacia adelante con energía renovada. Ya sea que estés entrenando para una competición o disfrutando de un trote diario, las New Balance 880 v14 son la elección perfecta para los corredores que buscan un equilibrio perfecto entre rendimiento y confort. ¡Desata tu potencial con cada carrera!','Drop de 8 mm**\n\n Fresh Foam X con Bio Eva\n\n    Sintético/malla\n\n    Ajuste con Cordones\n\n    Peso: 7.4 oz | 209 g\n',6,46,'New Balance','Azul','https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-880-v14-azul-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',4,'Zapatillas Running Mujer 880 v14'),(10,100,99990,'Zapatilla Runing para quienes disfrutan de la actividad al aire libre','Descubre la fusión perfecta entre tecnología avanzada y comodidad suprema con las zapatillas de running New Balance 880 v14. Diseñadas para impulsar tu rendimiento a nuevas alturas, estas zapatillas ofrecen una amortiguación responsiva que absorbe el impacto en cada zancada, proporcionando una sensación de suavidad y agilidad. La parte superior de malla transpirable brinda un ajuste cómodo y ventilado, manteniendo tus pies frescos durante toda la carrera. La estructura ligera y el soporte estratégico trabajan juntos para ofrecer estabilidad sin sacrificar la flexibilidad, permitiéndote moverte con confianza y fluidez en cada paso. La tecnología de entresuela FuelCell proporciona una respuesta rápida y una sensación de impulso, impulsándote hacia adelante con energía renovada. Ya sea que estés entrenando para una competición o disfrutando de un trote diario, las New Balance 880 v14 son la elección perfecta para los corredores que buscan un equilibrio perfecto entre rendimiento y confort. ¡Desata tu potencial con cada carrera!','Drop de 8 mm**\n\n Fresh Foam X con Bio Eva\n\n    Sintético/malla\n\n    Ajuste con Cordones\n\n    Peso: 7.4 oz | 209 g\n',7,45,'New Balance','Azul','https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-880-v14-negra-superior.png?quality=80&bg-color=255,255,255&fit=bounds&height=90&width=90&canvas=90:90',4,'Zapatillas Running Mujer 880 v14'),(11,100,99990,'Zapatilla Runing para quienes disfrutan de la actividad al aire libre','Descubre la fusión perfecta entre tecnología avanzada y comodidad suprema con las zapatillas de running New Balance 880 v14. Diseñadas para impulsar tu rendimiento a nuevas alturas, estas zapatillas ofrecen una amortiguación responsiva que absorbe el impacto en cada zancada, proporcionando una sensación de suavidad y agilidad. La parte superior de malla transpirable brinda un ajuste cómodo y ventilado, manteniendo tus pies frescos durante toda la carrera. La estructura ligera y el soporte estratégico trabajan juntos para ofrecer estabilidad sin sacrificar la flexibilidad, permitiéndote moverte con confianza y fluidez en cada paso. La tecnología de entresuela FuelCell proporciona una respuesta rápida y una sensación de impulso, impulsándote hacia adelante con energía renovada. Ya sea que estés entrenando para una competición o disfrutando de un trote diario, las New Balance 880 v14 son la elección perfecta para los corredores que buscan un equilibrio perfecto entre rendimiento y confort. ¡Desata tu potencial con cada carrera!','Drop de 8 mm**\n\n Fresh Foam X con Bio Eva\n\n    Sintético/malla\n\n    Ajuste con Cordones\n\n    Peso: 7.4 oz | 209 g\n',7,49,'New Balance','Azul','https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-880-v14-negra-superior.png?quality=80&bg-color=255,255,255&fit=bounds&height=90&width=90&canvas=90:90',4,'Zapatillas Running Mujer 880 v14'),(12,100,99990,'Zapatilla Runing para quienes disfrutan de la actividad al aire libre','Descubre la fusión perfecta entre tecnología avanzada y comodidad suprema con las zapatillas de running New Balance 880 v14. Diseñadas para impulsar tu rendimiento a nuevas alturas, estas zapatillas ofrecen una amortiguación responsiva que absorbe el impacto en cada zancada, proporcionando una sensación de suavidad y agilidad. La parte superior de malla transpirable brinda un ajuste cómodo y ventilado, manteniendo tus pies frescos durante toda la carrera. La estructura ligera y el soporte estratégico trabajan juntos para ofrecer estabilidad sin sacrificar la flexibilidad, permitiéndote moverte con confianza y fluidez en cada paso. La tecnología de entresuela FuelCell proporciona una respuesta rápida y una sensación de impulso, impulsándote hacia adelante con energía renovada. Ya sea que estés entrenando para una competición o disfrutando de un trote diario, las New Balance 880 v14 son la elección perfecta para los corredores que buscan un equilibrio perfecto entre rendimiento y confort. ¡Desata tu potencial con cada carrera!','Drop de 8 mm**\n\n Fresh Foam X con Bio Eva\n\n    Sintético/malla\n\n    Ajuste con Cordones\n\n    Peso: 7.4 oz | 209 g\n',7,48,'New Balance','Azul','https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-880-v14-negra-superior.png?quality=80&bg-color=255,255,255&fit=bounds&height=90&width=90&canvas=90:90',4,'Zapatillas Running Mujer 880 v14'),(13,30,229990,'Zapatilla Runing para entisiastas del deporte, alto rendimiento y comodidad','Las Adizero Adios Pro 3 son la máxima expresión de los productos Adizero Racing. Fueron diseñadas con y para atletas para lograr hazañas increíbles. Estas zapatillas de running adidas están diseñadas para optimizar la eficiencia del running. Nuestras varillas ENERGYRODS 2.0 de carbono ofrecen ligereza y firmeza para pasos ágiles y eficientes. La tecnología LIGHTSTRIKE PRO ultraliviana amortigua cada paso con las tres capas de espuma resistente que te ayudan a mantener la energía a largo plazo. Todo sobre una delgada suela de caucho textil para un agarre extraordinario en condiciones mojadas y secas.','    Corte clásico\n    Parte superior sintética\n    Forro interno textil\n    Varillas ENERGYRODS 2.0 que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n    Peso: 223 gramos (talla CHI 40,5)\n    Caída mediasuela: 6 mm (talón: 40 mm / antepié: 34 mm)\n    La parte superior contiene al menos un 50% de material reciclado\n    Color del artículo: Crystal White / Lucid Lemon / Blue Burst\n    Número de artículo: IG6441',8,46,'Adidas','Negro','https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2b613a79d46d43af859cf9dfc86318d4_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Negro_IG6439_HM5.jpg',5,'Zapatillas ADIZERO ADIOS PRO 3'),(14,30,229990,'Zapatilla Runing para entisiastas del deporte, alto rendimiento y comodidad','Las Adizero Adios Pro 3 son la máxima expresión de los productos Adizero Racing. Fueron diseñadas con y para atletas para lograr hazañas increíbles. Estas zapatillas de running adidas están diseñadas para optimizar la eficiencia del running. Nuestras varillas ENERGYRODS 2.0 de carbono ofrecen ligereza y firmeza para pasos ágiles y eficientes. La tecnología LIGHTSTRIKE PRO ultraliviana amortigua cada paso con las tres capas de espuma resistente que te ayudan a mantener la energía a largo plazo. Todo sobre una delgada suela de caucho textil para un agarre extraordinario en condiciones mojadas y secas.','    Corte clásico\n    Parte superior sintética\n    Forro interno textil\n    Varillas ENERGYRODS 2.0 que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n    Peso: 223 gramos (talla CHI 40,5)\n    Caída mediasuela: 6 mm (talón: 40 mm / antepié: 34 mm)\n    La parte superior contiene al menos un 50% de material reciclado\n    Color del artículo: Crystal White / Lucid Lemon / Blue Burst\n    Número de artículo: IG6441',8,48,'Adidas','Negro','https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2b613a79d46d43af859cf9dfc86318d4_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Negro_IG6439_HM5.jpg',5,'Zapatillas ADIZERO ADIOS PRO 3'),(15,30,229990,'Zapatilla Runing para entisiastas del deporte, alto rendimiento y comodidad','Las Adizero Adios Pro 3 son la máxima expresión de los productos Adizero Racing. Fueron diseñadas con y para atletas para lograr hazañas increíbles. Estas zapatillas de running adidas están diseñadas para optimizar la eficiencia del running. Nuestras varillas ENERGYRODS 2.0 de carbono ofrecen ligereza y firmeza para pasos ágiles y eficientes. La tecnología LIGHTSTRIKE PRO ultraliviana amortigua cada paso con las tres capas de espuma resistente que te ayudan a mantener la energía a largo plazo. Todo sobre una delgada suela de caucho textil para un agarre extraordinario en condiciones mojadas y secas.','    Corte clásico\n    Parte superior sintética\n    Forro interno textil\n    Varillas ENERGYRODS 2.0 que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n    Peso: 223 gramos (talla CHI 40,5)\n    Caída mediasuela: 6 mm (talón: 40 mm / antepié: 34 mm)\n    La parte superior contiene al menos un 50% de material reciclado\n    Color del artículo: Crystal White / Lucid Lemon / Blue Burst\n    Número de artículo: IG6441',8,52,'Adidas','Negro','https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2b613a79d46d43af859cf9dfc86318d4_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Negro_IG6439_HM5.jpg',5,'Zapatillas ADIZERO ADIOS PRO 3'),(16,50,229990,'Zapatilla Runing para entisiastas del deporte, alto rendimiento y comodidad','Las Adizero Adios Pro 3 son la máxima expresión de los productos Adizero Racing. Fueron diseñadas con y para atletas para lograr hazañas increíbles. Estas zapatillas de running adidas están diseñadas para optimizar la eficiencia del running. Nuestras varillas ENERGYRODS 2.0 de carbono ofrecen ligereza y firmeza para pasos ágiles y eficientes. La tecnología LIGHTSTRIKE PRO ultraliviana amortigua cada paso con las tres capas de espuma resistente que te ayudan a mantener la energía a largo plazo. Todo sobre una delgada suela de caucho textil para un agarre extraordinario en condiciones mojadas y secas.','    Corte clásico\n    Parte superior sintética\n    Forro interno textil\n    Varillas ENERGYRODS 2.0 que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n    Peso: 223 gramos (talla CHI 40,5)\n    Caída mediasuela: 6 mm (talón: 40 mm / antepié: 34 mm)\n    La parte superior contiene al menos un 50% de material reciclado\n    Color del artículo: Crystal White / Lucid Lemon / Blue Burst\n    Número de artículo: IG6441',9,41,'Adidas','Verde','https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2a35abb799174437a80d99e2e8958b1c_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Verde_IG6445_HM3_hover.jpg',5,'Zapatillas ADIZERO ADIOS PRO 3'),(17,50,229990,'Zapatilla Runing para entisiastas del deporte, alto rendimiento y comodidad','Las Adizero Adios Pro 3 son la máxima expresión de los productos Adizero Racing. Fueron diseñadas con y para atletas para lograr hazañas increíbles. Estas zapatillas de running adidas están diseñadas para optimizar la eficiencia del running. Nuestras varillas ENERGYRODS 2.0 de carbono ofrecen ligereza y firmeza para pasos ágiles y eficientes. La tecnología LIGHTSTRIKE PRO ultraliviana amortigua cada paso con las tres capas de espuma resistente que te ayudan a mantener la energía a largo plazo. Todo sobre una delgada suela de caucho textil para un agarre extraordinario en condiciones mojadas y secas.','    Corte clásico\n    Parte superior sintética\n    Forro interno textil\n    Varillas ENERGYRODS 2.0 que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n    Peso: 223 gramos (talla CHI 40,5)\n    Caída mediasuela: 6 mm (talón: 40 mm / antepié: 34 mm)\n    La parte superior contiene al menos un 50% de material reciclado\n    Color del artículo: Crystal White / Lucid Lemon / Blue Burst\n    Número de artículo: IG6441',9,43,'Adidas','Verde','https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2a35abb799174437a80d99e2e8958b1c_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Verde_IG6445_HM3_hover.jpg',5,'Zapatillas ADIZERO ADIOS PRO 3'),(18,50,229990,'Zapatilla Runing para entisiastas del deporte, alto rendimiento y comodidad','Las Adizero Adios Pro 3 son la máxima expresión de los productos Adizero Racing. Fueron diseñadas con y para atletas para lograr hazañas increíbles. Estas zapatillas de running adidas están diseñadas para optimizar la eficiencia del running. Nuestras varillas ENERGYRODS 2.0 de carbono ofrecen ligereza y firmeza para pasos ágiles y eficientes. La tecnología LIGHTSTRIKE PRO ultraliviana amortigua cada paso con las tres capas de espuma resistente que te ayudan a mantener la energía a largo plazo. Todo sobre una delgada suela de caucho textil para un agarre extraordinario en condiciones mojadas y secas.','    Corte clásico\n    Parte superior sintética\n    Forro interno textil\n    Varillas ENERGYRODS 2.0 que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n    Peso: 223 gramos (talla CHI 40,5)\n    Caída mediasuela: 6 mm (talón: 40 mm / antepié: 34 mm)\n    La parte superior contiene al menos un 50% de material reciclado\n    Color del artículo: Crystal White / Lucid Lemon / Blue Burst\n    Número de artículo: IG6441',9,44,'Adidas','Verde','https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2a35abb799174437a80d99e2e8958b1c_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Verde_IG6445_HM3_hover.jpg',5,'Zapatillas ADIZERO ADIOS PRO 3'),(19,50,229990,'Zapatilla Runing para entisiastas del deporte, alto rendimiento y comodidad','Las Adizero Adios Pro 3 son la máxima expresión de los productos Adizero Racing. Fueron diseñadas con y para atletas para lograr hazañas increíbles. Estas zapatillas de running adidas están diseñadas para optimizar la eficiencia del running. Nuestras varillas ENERGYRODS 2.0 de carbono ofrecen ligereza y firmeza para pasos ágiles y eficientes. La tecnología LIGHTSTRIKE PRO ultraliviana amortigua cada paso con las tres capas de espuma resistente que te ayudan a mantener la energía a largo plazo. Todo sobre una delgada suela de caucho textil para un agarre extraordinario en condiciones mojadas y secas.','    Corte clásico\n    Parte superior sintética\n    Forro interno textil\n    Varillas ENERGYRODS 2.0 que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n    Peso: 223 gramos (talla CHI 40,5)\n    Caída mediasuela: 6 mm (talón: 40 mm / antepié: 34 mm)\n    La parte superior contiene al menos un 50% de material reciclado\n    Color del artículo: Crystal White / Lucid Lemon / Blue Burst\n    Número de artículo: IG6441',9,47,'Adidas','Verde','https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2a35abb799174437a80d99e2e8958b1c_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Verde_IG6445_HM3_hover.jpg',5,'Zapatillas ADIZERO ADIOS PRO 3'),(20,50,229990,'Zapatilla Runing para entisiastas del deporte, alto rendimiento y comodidad','Las Adizero Adios Pro 3 son la máxima expresión de los productos Adizero Racing. Fueron diseñadas con y para atletas para lograr hazañas increíbles. Estas zapatillas de running adidas están diseñadas para optimizar la eficiencia del running. Nuestras varillas ENERGYRODS 2.0 de carbono ofrecen ligereza y firmeza para pasos ágiles y eficientes. La tecnología LIGHTSTRIKE PRO ultraliviana amortigua cada paso con las tres capas de espuma resistente que te ayudan a mantener la energía a largo plazo. Todo sobre una delgada suela de caucho textil para un agarre extraordinario en condiciones mojadas y secas.','    Corte clásico\n    Parte superior sintética\n    Forro interno textil\n    Varillas ENERGYRODS 2.0 que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n    Peso: 223 gramos (talla CHI 40,5)\n    Caída mediasuela: 6 mm (talón: 40 mm / antepié: 34 mm)\n    La parte superior contiene al menos un 50% de material reciclado\n    Color del artículo: Crystal White / Lucid Lemon / Blue Burst\n    Número de artículo: IG6441',9,48,'Adidas','Verde','https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2a35abb799174437a80d99e2e8958b1c_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Verde_IG6445_HM3_hover.jpg',5,'Zapatillas ADIZERO ADIOS PRO 3'),(21,50,229990,'Zapatilla Runing para entisiastas del deporte, alto rendimiento y comodidad','Las Adizero Adios Pro 3 son la máxima expresión de los productos Adizero Racing. Fueron diseñadas con y para atletas para lograr hazañas increíbles. Estas zapatillas de running adidas están diseñadas para optimizar la eficiencia del running. Nuestras varillas ENERGYRODS 2.0 de carbono ofrecen ligereza y firmeza para pasos ágiles y eficientes. La tecnología LIGHTSTRIKE PRO ultraliviana amortigua cada paso con las tres capas de espuma resistente que te ayudan a mantener la energía a largo plazo. Todo sobre una delgada suela de caucho textil para un agarre extraordinario en condiciones mojadas y secas.','    Corte clásico\n    Parte superior sintética\n    Forro interno textil\n    Varillas ENERGYRODS 2.0 que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n    Peso: 223 gramos (talla CHI 40,5)\n    Caída mediasuela: 6 mm (talón: 40 mm / antepié: 34 mm)\n    La parte superior contiene al menos un 50% de material reciclado\n    Color del artículo: Crystal White / Lucid Lemon / Blue Burst\n    Número de artículo: IG6441',9,49,'Adidas','Verde','https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2a35abb799174437a80d99e2e8958b1c_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Verde_IG6445_HM3_hover.jpg',5,'Zapatillas ADIZERO ADIOS PRO 3'),(22,70,149990,'Zapatilla de gran comodidad y versatilidad','La Maratón de Boston® es una carrera. Pero también es un objetivo, un plan de entrenamiento y está en tu mente todos los días antes del gran reto. Las zapatillas Adizero Boston 12 están diseñadas para correr distancias medias y largas. Inyectan una sensación de propulsión a cada entrenamiento con la infusión de fibra de vidrio con las varillas ENERGYRODS 2.0, que limitan la pérdida de energía bajo el pie. Son rápidas, pero esto no se consigue a expensas de la durabilidad. La mediasuela combina la amortiguación Lightstrike Pro ultraliviana con la nueva versión de la tecnología LIGHTSTRIKE 2.0 EVA resistente','    Ajuste clásico\n    Sistema de atado de cordones\n    Exterior liviano de malla\n    Forro interno textil\n    Varillas ENERGYRODS que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n\n    Peso: 227 g (Talle AR 37,5)\n    Caída mediasuela: 7 mm (talón: 19 mm / antepié: 12 mm) 38 mm / antepié: 31 mm)\n    Suela de caucho Continental™ Rubber\n    El exterior contiene al menos un 50% de material reciclado\n    Color del artículo: Core Black / Cloud White / Carbon',10,42,'Adidas','Rosado','https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/9830b8efb0fe46bea873a7c8f1f765db_9366/Zapatillas_Adizero_Boston_12_Beige_IG3325_HM1.jpg',6,'Zapatillas Adizero Boston 12'),(23,70,149990,'Zapatilla de gran comodidad y versatilidad','La Maratón de Boston® es una carrera. Pero también es un objetivo, un plan de entrenamiento y está en tu mente todos los días antes del gran reto. Las zapatillas Adizero Boston 12 están diseñadas para correr distancias medias y largas. Inyectan una sensación de propulsión a cada entrenamiento con la infusión de fibra de vidrio con las varillas ENERGYRODS 2.0, que limitan la pérdida de energía bajo el pie. Son rápidas, pero esto no se consigue a expensas de la durabilidad. La mediasuela combina la amortiguación Lightstrike Pro ultraliviana con la nueva versión de la tecnología LIGHTSTRIKE 2.0 EVA resistente','    Ajuste clásico\n    Sistema de atado de cordones\n    Exterior liviano de malla\n    Forro interno textil\n    Varillas ENERGYRODS que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n\n    Peso: 227 g (Talle AR 37,5)\n    Caída mediasuela: 7 mm (talón: 19 mm / antepié: 12 mm) 38 mm / antepié: 31 mm)\n    Suela de caucho Continental™ Rubber\n    El exterior contiene al menos un 50% de material reciclado\n    Color del artículo: Core Black / Cloud White / Carbon',10,45,'Adidas','Rosado','https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/9830b8efb0fe46bea873a7c8f1f765db_9366/Zapatillas_Adizero_Boston_12_Beige_IG3325_HM1.jpg',6,'Zapatillas Adizero Boston 12'),(24,69,149990,'Zapatilla de gran comodidad y versatilidad','La Maratón de Boston® es una carrera. Pero también es un objetivo, un plan de entrenamiento y está en tu mente todos los días antes del gran reto. Las zapatillas Adizero Boston 12 están diseñadas para correr distancias medias y largas. Inyectan una sensación de propulsión a cada entrenamiento con la infusión de fibra de vidrio con las varillas ENERGYRODS 2.0, que limitan la pérdida de energía bajo el pie. Son rápidas, pero esto no se consigue a expensas de la durabilidad. La mediasuela combina la amortiguación Lightstrike Pro ultraliviana con la nueva versión de la tecnología LIGHTSTRIKE 2.0 EVA resistente','    Ajuste clásico\n    Sistema de atado de cordones\n    Exterior liviano de malla\n    Forro interno textil\n    Varillas ENERGYRODS que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n\n    Peso: 227 g (Talle AR 37,5)\n    Caída mediasuela: 7 mm (talón: 19 mm / antepié: 12 mm) 38 mm / antepié: 31 mm)\n    Suela de caucho Continental™ Rubber\n    El exterior contiene al menos un 50% de material reciclado\n    Color del artículo: Core Black / Cloud White / Carbon',10,48,'Adidas','Rosado','https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/9830b8efb0fe46bea873a7c8f1f765db_9366/Zapatillas_Adizero_Boston_12_Beige_IG3325_HM1.jpg',6,'Zapatillas Adizero Boston 12'),(25,70,149990,'Zapatilla de gran comodidad y versatilidad','La Maratón de Boston® es una carrera. Pero también es un objetivo, un plan de entrenamiento y está en tu mente todos los días antes del gran reto. Las zapatillas Adizero Boston 12 están diseñadas para correr distancias medias y largas. Inyectan una sensación de propulsión a cada entrenamiento con la infusión de fibra de vidrio con las varillas ENERGYRODS 2.0, que limitan la pérdida de energía bajo el pie. Son rápidas, pero esto no se consigue a expensas de la durabilidad. La mediasuela combina la amortiguación Lightstrike Pro ultraliviana con la nueva versión de la tecnología LIGHTSTRIKE 2.0 EVA resistente','    Ajuste clásico\n    Sistema de atado de cordones\n    Exterior liviano de malla\n    Forro interno textil\n    Varillas ENERGYRODS que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n\n    Peso: 227 g (Talle AR 37,5)\n    Caída mediasuela: 7 mm (talón: 19 mm / antepié: 12 mm) 38 mm / antepié: 31 mm)\n    Suela de caucho Continental™ Rubber\n    El exterior contiene al menos un 50% de material reciclado\n    Color del artículo: Core Black / Cloud White / Carbon',10,43,'Adidas','Rosado','https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/9830b8efb0fe46bea873a7c8f1f765db_9366/Zapatillas_Adizero_Boston_12_Beige_IG3325_HM1.jpg',6,'Zapatillas Adizero Boston 12'),(26,99,149990,'Zapatilla de gran comodidad y versatilidad','La Maratón de Boston® es una carrera. Pero también es un objetivo, un plan de entrenamiento y está en tu mente todos los días antes del gran reto. Las zapatillas Adizero Boston 12 están diseñadas para correr distancias medias y largas. Inyectan una sensación de propulsión a cada entrenamiento con la infusión de fibra de vidrio con las varillas ENERGYRODS 2.0, que limitan la pérdida de energía bajo el pie. Son rápidas, pero esto no se consigue a expensas de la durabilidad. La mediasuela combina la amortiguación Lightstrike Pro ultraliviana con la nueva versión de la tecnología LIGHTSTRIKE 2.0 EVA resistente','    Ajuste clásico\n    Sistema de atado de cordones\n    Exterior liviano de malla\n    Forro interno textil\n    Varillas ENERGYRODS que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n\n    Peso: 227 g (Talle AR 37,5)\n    Caída mediasuela: 7 mm (talón: 19 mm / antepié: 12 mm) 38 mm / antepié: 31 mm)\n    Suela de caucho Continental™ Rubber\n    El exterior contiene al menos un 50% de material reciclado\n    Color del artículo: Core Black / Cloud White / Carbon',11,43,'Adidas','Verde','https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/a2f4b3fcc7014f67bbcbb53c3ee26d3a_9366/Zapatillas_Adizero_Boston_12_Turquesa_ID6901_HM1.jpg',6,'Zapatillas Adizero Boston 12'),(27,100,149990,'Zapatilla de gran comodidad y versatilidad','La Maratón de Boston® es una carrera. Pero también es un objetivo, un plan de entrenamiento y está en tu mente todos los días antes del gran reto. Las zapatillas Adizero Boston 12 están diseñadas para correr distancias medias y largas. Inyectan una sensación de propulsión a cada entrenamiento con la infusión de fibra de vidrio con las varillas ENERGYRODS 2.0, que limitan la pérdida de energía bajo el pie. Son rápidas, pero esto no se consigue a expensas de la durabilidad. La mediasuela combina la amortiguación Lightstrike Pro ultraliviana con la nueva versión de la tecnología LIGHTSTRIKE 2.0 EVA resistente','    Ajuste clásico\n    Sistema de atado de cordones\n    Exterior liviano de malla\n    Forro interno textil\n    Varillas ENERGYRODS que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n\n    Peso: 227 g (Talle AR 37,5)\n    Caída mediasuela: 7 mm (talón: 19 mm / antepié: 12 mm) 38 mm / antepié: 31 mm)\n    Suela de caucho Continental™ Rubber\n    El exterior contiene al menos un 50% de material reciclado\n    Color del artículo: Core Black / Cloud White / Carbon',11,45,'Adidas','Verde','https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/a2f4b3fcc7014f67bbcbb53c3ee26d3a_9366/Zapatillas_Adizero_Boston_12_Turquesa_ID6901_HM1.jpg',6,'Zapatillas Adizero Boston 12'),(28,100,149990,'Zapatilla de gran comodidad y versatilidad','La Maratón de Boston® es una carrera. Pero también es un objetivo, un plan de entrenamiento y está en tu mente todos los días antes del gran reto. Las zapatillas Adizero Boston 12 están diseñadas para correr distancias medias y largas. Inyectan una sensación de propulsión a cada entrenamiento con la infusión de fibra de vidrio con las varillas ENERGYRODS 2.0, que limitan la pérdida de energía bajo el pie. Son rápidas, pero esto no se consigue a expensas de la durabilidad. La mediasuela combina la amortiguación Lightstrike Pro ultraliviana con la nueva versión de la tecnología LIGHTSTRIKE 2.0 EVA resistente','    Ajuste clásico\n    Sistema de atado de cordones\n    Exterior liviano de malla\n    Forro interno textil\n    Varillas ENERGYRODS que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n\n    Peso: 227 g (Talle AR 37,5)\n    Caída mediasuela: 7 mm (talón: 19 mm / antepié: 12 mm) 38 mm / antepié: 31 mm)\n    Suela de caucho Continental™ Rubber\n    El exterior contiene al menos un 50% de material reciclado\n    Color del artículo: Core Black / Cloud White / Carbon',11,37,'Adidas','Verde','https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/a2f4b3fcc7014f67bbcbb53c3ee26d3a_9366/Zapatillas_Adizero_Boston_12_Turquesa_ID6901_HM1.jpg',6,'Zapatillas Adizero Boston 12'),(29,50,69990,'Zapatilla Runing para entisiastas del deporte','Experimente la mejor comodidad de su clase con New Balance Fresh Foam X EVOZ v3. Ahora con Fresh Foam X, este zapato suave y lujoso equilibra la innovación comprobada con comodidad y soporte accesibles durante todo el día. Combinado con una parte superior de malla de ingeniería liviana para una transpirabilidad y elasticidad impresionantes, esta zapatilla para correr de primera calidad está diseñada para ser su entrenador diario.','a entresuela Fresh Foam X ofrece nuestra experiencia Fresh Foam más acolchada para una comodidad increíble\n\nLa parte superior presenta una construcción sin costuras para un ajuste y una sensación elegantes\n\nParte superior de tela suave y malla diseñada\n\nSuela de goma integrada\n\nCierre de cordones ajustable para un ajuste personalizado\n\nDrop de 8 mm**\n',12,42,'New Balance','Negro','https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-evoz-v3-negra-superior_2.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',7,'Zapatillas Running Mujer Evoz V3 '),(30,50,69990,'Zapatilla Runing para entisiastas del deporte','Experimente la mejor comodidad de su clase con New Balance Fresh Foam X EVOZ v3. Ahora con Fresh Foam X, este zapato suave y lujoso equilibra la innovación comprobada con comodidad y soporte accesibles durante todo el día. Combinado con una parte superior de malla de ingeniería liviana para una transpirabilidad y elasticidad impresionantes, esta zapatilla para correr de primera calidad está diseñada para ser su entrenador diario.','a entresuela Fresh Foam X ofrece nuestra experiencia Fresh Foam más acolchada para una comodidad increíble\n\nLa parte superior presenta una construcción sin costuras para un ajuste y una sensación elegantes\n\nParte superior de tela suave y malla diseñada\n\nSuela de goma integrada\n\nCierre de cordones ajustable para un ajuste personalizado\n\nDrop de 8 mm**\n',12,43,'New Balance','Negro','https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-evoz-v3-negra-superior_2.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',7,'Zapatillas Running Mujer Evoz V3 '),(31,50,69990,'Zapatilla Runing para entisiastas del deporte','Experimente la mejor comodidad de su clase con New Balance Fresh Foam X EVOZ v3. Ahora con Fresh Foam X, este zapato suave y lujoso equilibra la innovación comprobada con comodidad y soporte accesibles durante todo el día. Combinado con una parte superior de malla de ingeniería liviana para una transpirabilidad y elasticidad impresionantes, esta zapatilla para correr de primera calidad está diseñada para ser su entrenador diario.','a entresuela Fresh Foam X ofrece nuestra experiencia Fresh Foam más acolchada para una comodidad increíble\n\nLa parte superior presenta una construcción sin costuras para un ajuste y una sensación elegantes\n\nParte superior de tela suave y malla diseñada\n\nSuela de goma integrada\n\nCierre de cordones ajustable para un ajuste personalizado\n\nDrop de 8 mm**\n',12,42,'New Balance','Negro','https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-evoz-v3-negra-superior_2.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',7,'Zapatillas Running Mujer Evoz V3 '),(32,50,69990,'Zapatilla Runing para entisiastas del deporte','Experimente la mejor comodidad de su clase con New Balance Fresh Foam X EVOZ v3. Ahora con Fresh Foam X, este zapato suave y lujoso equilibra la innovación comprobada con comodidad y soporte accesibles durante todo el día. Combinado con una parte superior de malla de ingeniería liviana para una transpirabilidad y elasticidad impresionantes, esta zapatilla para correr de primera calidad está diseñada para ser su entrenador diario.','a entresuela Fresh Foam X ofrece nuestra experiencia Fresh Foam más acolchada para una comodidad increíble\n\nLa parte superior presenta una construcción sin costuras para un ajuste y una sensación elegantes\n\nParte superior de tela suave y malla diseñada\n\nSuela de goma integrada\n\nCierre de cordones ajustable para un ajuste personalizado\n\nDrop de 8 mm**\n',12,45,'New Balance','Negro','https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-evoz-v3-negra-superior_2.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',7,'Zapatillas Running Mujer Evoz V3 '),(33,50,69990,'Zapatilla Runing para entisiastas del deporte','Experimente la mejor comodidad de su clase con New Balance Fresh Foam X EVOZ v3. Ahora con Fresh Foam X, este zapato suave y lujoso equilibra la innovación comprobada con comodidad y soporte accesibles durante todo el día. Combinado con una parte superior de malla de ingeniería liviana para una transpirabilidad y elasticidad impresionantes, esta zapatilla para correr de primera calidad está diseñada para ser su entrenador diario.','a entresuela Fresh Foam X ofrece nuestra experiencia Fresh Foam más acolchada para una comodidad increíble\n\nLa parte superior presenta una construcción sin costuras para un ajuste y una sensación elegantes\n\nParte superior de tela suave y malla diseñada\n\nSuela de goma integrada\n\nCierre de cordones ajustable para un ajuste personalizado\n\nDrop de 8 mm**\n',12,47,'New Balance','Negro','https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-evoz-v3-negra-superior_2.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',7,'Zapatillas Running Mujer Evoz V3 ');
/*!40000 ALTER TABLE `final_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordered_products`
--

DROP TABLE IF EXISTS `ordered_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordered_products` (
  `ordered_product_id` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `cart_id` int NOT NULL,
  `final_product_id` int DEFAULT NULL,
  PRIMARY KEY (`ordered_product_id`),
  KEY `asdf_idx` (`cart_id`),
  KEY `fk_ordered_products_2_idx` (`final_product_id`),
  CONSTRAINT `fk_ordered_products_1` FOREIGN KEY (`cart_id`) REFERENCES `carts` (`cart_id`),
  CONSTRAINT `fk_ordered_products_2` FOREIGN KEY (`final_product_id`) REFERENCES `final_products` (`final_product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordered_products`
--

LOCK TABLES `ordered_products` WRITE;
/*!40000 ALTER TABLE `ordered_products` DISABLE KEYS */;
INSERT INTO `ordered_products` VALUES (1,1,2,1),(4,1,3,26),(5,1,3,24),(6,1,3,7);
/*!40000 ALTER TABLE `ordered_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales` (
  `sale_id` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `direction_id` int DEFAULT NULL,
  `userName` varchar(45) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `total` int DEFAULT NULL,
  `items` int DEFAULT NULL,
  `cart_id` int DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sale_id`),
  KEY `fk_sales_1_idx` (`direction_id`),
  CONSTRAINT `fk_sales_1` FOREIGN KEY (`direction_id`) REFERENCES `directions` (`direction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (1,'2024-07-15',1,'jperez',2,62990,1,2,'Realizada'),(2,'2024-07-15',2,'rodrigo',1,0,0,1,'Anulada'),(3,'2024-07-15',2,'rodrigo',1,399970,3,3,'Realizada');
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sizes`
--

DROP TABLE IF EXISTS `sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sizes` (
  `size_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`size_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sizes`
--

LOCK TABLES `sizes` WRITE;
/*!40000 ALTER TABLE `sizes` DISABLE KEYS */;
INSERT INTO `sizes` VALUES (28,'Sin Talla'),(29,'XS'),(30,'S'),(31,'M'),(32,'L'),(33,'XL'),(34,'XXL'),(35,'30'),(36,'31'),(37,'32'),(38,'33'),(39,'34'),(40,'35'),(41,'36'),(42,'37'),(43,'38'),(44,'39'),(45,'40'),(46,'41'),(47,'42'),(48,'43'),(49,'44'),(50,'45'),(51,'46'),(52,'47'),(53,'48'),(54,'49'),(55,'50');
/*!40000 ALTER TABLE `sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'RODRIGO','ayelef','rodr1alex27@gmail.com','rodrigo','$2a$10$4NStmMOKRcTmjY17U7JDbefB/xqvh4g2fjIbUTVQf715sLdS1Ryxq'),(2,'juan','perez','jperez@gmail.com','jperez','$2a$10$cDGSbFDdE8k4CNtPxYQFe.J23T0mslb6Dhjsbax/0AzEi8nkDIbpK');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_users_roles_1_idx` (`role_id`),
  CONSTRAINT `fk_roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `fk_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1),(2,1),(1,2);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-15 21:43:31
