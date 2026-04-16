-- MySQL dump 10.13  Distrib 8.0.39, for Linux (x86_64)
--
-- Host: localhost    Database: tienda
-- ------------------------------------------------------
-- Server version	8.0.39-0ubuntu0.24.04.1

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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_product_images`
--

LOCK TABLES `base_product_images` WRITE;
/*!40000 ALTER TABLE `base_product_images` DISABLE KEYS */;
INSERT INTO `base_product_images` VALUES (1,'https://sparta.cl/media/catalog/product/z/a/zapatillas-running-mujer-nike-downshifter-13-blanca-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',NULL),(2,'https://sparta.cl/media/catalog/product/z/a/zapatillas-running-mujer-nike-downshifter-13-blanca-superior.png?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',NULL),(3,'https://sparta.cl/media/catalog/product/z/a/zapatillas-running-mujer-nike-downshifter-13-blanca-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',1),(4,'https://sparta.cl/media/catalog/product/z/a/zapatillas-running-mujer-nike-downshifter-13-blanca-superior.png?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',1),(5,'https://sparta.cl/media/catalog/product/z/a/zapatillas-running-hombre-adidas-duramo-sl-negra-lateral.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',NULL),(6,'https://sparta.cl/media/catalog/product/z/a/zapatillas-running-hombre-adidas-duramo-sl-negra-inferior.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',NULL),(9,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-1080-v13-azul-marino-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',3),(10,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-880-v14-negra-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',4),(11,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2259ad072e1148fe92b04fe92d1a20d8_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Blanco_IG6441_HM3_hover.jpg',5),(12,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/0f3c3eff8b2e4037915c49032c017eda_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Blanco_IG6441_HM4.jpg',5),(13,'https://assets.adidas.com/images/h_2000,f_auto,q_auto,fl_lossy,c_fill,g_auto/87176ee576f24357b3843634a1e5d5bb_9366/Zapatillas_Adizero_Boston_12_Negro_HQ2171_HM1.jpg',6),(14,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-evoz-v3-negra-lateral_2.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',7),(15,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-evoz-v3-negra-lateral-interior_2.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',7),(31,'https://sparta.cl/media/catalog/product/b/i/bicicleta-ruta-trek-emonda-sl-5.png?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',19),(32,'https://sparta.cl/media/catalog/product/b/i/bicicleta-ruta-trek-emonda-sl-5-gris-2023.png?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',19),(33,'https://sparta.cl/media/catalog/product/b/i/bicicleta-ruta-trek-emonda-sl-5-gris-2023-manubrio.png?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',19),(34,'https://www.ibikes.cl/wp-content/uploads/2020/06/T4COD100005MBK-768x768.jpg',20),(35,'https://www.ibikes.cl/wp-content/uploads/2016/09/LAKI-FLUOR-768x768.jpg',21),(36,'https://contents.mediadecathlon.com/p2141791/k$a63545fa07fe1fc241eae60df6fa68fe/reloj-gps-500.jpg?format=auto&quality=40&f=800x800',22),(37,'https://contents.mediadecathlon.com/p2206370/k$188bc9b9f094bf4b5820c6a60cbc62be/reloj-gps-500.jpg?format=auto&quality=40&f=800x800',22),(38,'https://contents.mediadecathlon.com/p2206381/k$bf6b1ae3186a8d8af8f11fe3a437c79d/reloj-gps-500.jpg?format=auto&quality=40&f=800x800',22),(39,'https://contents.mediadecathlon.com/p2148222/k$1be3b6efb6d8c5ffb643ee27d7b7e066/reloj-gps-500.jpg?format=auto&quality=40&f=800x800',22),(40,'https://contents.mediadecathlon.com/p2148212/k$0e2ad14c7bfe7bfc77218db475069d6e/reloj-gps-500.jpg?format=auto&quality=40&f=800x800',22),(41,'https://contents.mediadecathlon.com/p1773557/k$850fb437c333261f4d2cc684bb4f6232/traje-surf-corto-100-neopren-15-mm-mujer-negro.jpg?format=auto&quality=40&f=800x800',23),(42,'https://contents.mediadecathlon.com/p1941942/k$90cd45616adc10259c6aa82ece7aeceb/traje-surf-corto-100-neopren-15-mm-mujer-negro.jpg?format=auto&quality=40&f=800x800',23),(43,'https://contents.mediadecathlon.com/p1773554/k$8b760b08dc84e029863f9c65e295d7ea/traje-surf-corto-100-neopren-15-mm-mujer-negro.jpg?format=auto&quality=40&f=800x800',23),(44,'https://contents.mediadecathlon.com/p1941915/k$2745ea3a9f24a36f8205c7a261a6f845/traje-surf-corto-100-neopren-15-mm-mujer-negro.jpg?format=auto&quality=40&f=800x800',23),(45,'https://contents.mediadecathlon.com/p1773558/k$cda4a4c18eeac342317c11d68ee5f54a/traje-surf-corto-100-neopren-15-mm-mujer-negro.jpg?format=auto&quality=40&f=800x800',23);
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_products`
--

LOCK TABLES `base_products` WRITE;
/*!40000 ALTER TABLE `base_products` DISABLE KEYS */;
INSERT INTO `base_products` VALUES (1,'Zapatillas Running Mujer Downshifter 13','Ya sea que estés comenzando tu recorrido como corredor o seas un experto deseando cambiar tu ritmo, el Downshifter 13 está listo para acompañarte.',62990,'\n\nYa sea que estés comenzando tu recorrido como corredor o seas un experto deseando cambiar tu ritmo, el Downshifter 13 está listo para acompañarte. Con una parte superior renovada, amortiguación y durabilidad, te ayuda a encontrar ese impulso adicional o dar el primer paso hacia la consecución de tus objetivos.','    Hecho con Nike Grind\n    Malla Transpirable\n    Apoyo y seguridad\n',1),(3,'Zapatillas Running Hombre 1080 V13 ','Zapatilla Runing para entisiastas del deporte, hasta 21k',149990,'El modelo 1080 es la oferta cumbre de la línea de running de New Balance. Una combinación de tecnología de rendimiento de primera calidad y accesibilidad de amplio alcance ofrece a los corredores de todos los niveles de intensidad más comodidad en distancias más largas. En pocas palabras, no hay otro calzado como el 1080. El Fresh Foam X 1080v13 representa una progresión constante de las cualidades distintivas del modelo. Las transiciones suaves de la experiencia máxima de amortiguación bajo los pies se ajustan con','Mediasuela Fresh Foam X con aproximadamente un 3% de contenido biodegradable que brinda nuestra experiencia Fresh Foam más amortiguada para una comodidad increíble. El contenido biodegradable está hecho de recursos renovables para ayudar a reducir nuestra huella de carbono.\n\nTecnología de suela de goma NDurance que proporciona una durabilidad superior en áreas de alto desgaste para aprovechar al máximo el calzado.\n\nParte superior de malla de aire diseñada',3),(4,'Zapatillas Running Mujer 880 v14','Zapatilla Runing para quienes disfrutan de la actividad al aire libre',99990,'Descubre la fusión perfecta entre tecnología avanzada y comodidad suprema con las zapatillas de running New Balance 880 v14. Diseñadas para impulsar tu rendimiento a nuevas alturas, estas zapatillas ofrecen una amortiguación responsiva que absorbe el impacto en cada zancada, proporcionando una sensación de suavidad y agilidad. La parte superior de malla transpirable brinda un ajuste cómodo y ventilado, manteniendo tus pies frescos durante toda la carrera. La estructura ligera y el soporte estratégico trabajan juntos para ofrecer estabilidad sin sacrificar la flexibilidad, permitiéndote moverte con confianza y fluidez en cada paso. La tecnología de entresuela FuelCell proporciona una respuesta rápida y una sensación de impulso, impulsándote hacia adelante con energía renovada. Ya sea que estés entrenando para una competición o disfrutando de un trote diario, las New Balance 880 v14 son la elección perfecta para los corredores que buscan un equilibrio perfecto entre rendimiento y confort. ¡Desata tu potencial con cada carrera!','Drop de 8 mm**\n\n Fresh Foam X con Bio Eva\n\n    Sintético/malla\n\n    Ajuste con Cordones\n\n    Peso: 7.4 oz | 209 g\n',3),(5,'Zapatillas ADIZERO ADIOS PRO 3','Zapatilla Runing para entisiastas del deporte, alto rendimiento y comodidad',229990,'Las Adizero Adios Pro 3 son la máxima expresión de los productos Adizero Racing. Fueron diseñadas con y para atletas para lograr hazañas increíbles. Estas zapatillas de running adidas están diseñadas para optimizar la eficiencia del running. Nuestras varillas ENERGYRODS 2.0 de carbono ofrecen ligereza y firmeza para pasos ágiles y eficientes. La tecnología LIGHTSTRIKE PRO ultraliviana amortigua cada paso con las tres capas de espuma resistente que te ayudan a mantener la energía a largo plazo. Todo sobre una delgada suela de caucho textil para un agarre extraordinario en condiciones mojadas y secas.','    Corte clásico\n    Parte superior sintética\n    Forro interno textil\n    Varillas ENERGYRODS 2.0 que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n    Peso: 223 gramos (talla CHI 40,5)\n    Caída mediasuela: 6 mm (talón: 40 mm / antepié: 34 mm)\n    La parte superior contiene al menos un 50% de material reciclado\n    Color del artículo: Crystal White / Lucid Lemon / Blue Burst\n    Número de artículo: IG6441',2),(6,'Zapatillas Adizero Boston 12','Zapatilla de gran comodidad y versatilidad',149990,'La Maratón de Boston® es una carrera. Pero también es un objetivo, un plan de entrenamiento y está en tu mente todos los días antes del gran reto. Las zapatillas Adizero Boston 12 están diseñadas para correr distancias medias y largas.','    Ajuste clásico\n    Sistema de atado de cordones\n    Exterior liviano de malla\n    Forro interno textil\n    Varillas ENERGYRODS que limitan la pérdida de energía\n    Amortiguación Lightstrike Pro\n\n    Peso: 227 g (Talle AR 37,5)\n    Caída mediasuela: 7 mm (talón: 19 mm / antepié: 12 mm) 38 mm / antepié: 31 mm)\n    Suela de caucho Continental™ Rubber\n    El exterior contiene al menos un 50% de material reciclado\n    Color del artículo: Core Black / Cloud White / Carbon',2),(7,'Zapatillas Running Mujer Evoz V3 ','Zapatilla Runing para entisiastas del deporte',69990,'Experimente la mejor comodidad de su clase con New Balance Fresh Foam X EVOZ v3. Ahora con Fresh Foam X, este zapato suave y lujoso equilibra la innovación comprobada con comodidad y soporte accesibles durante todo el día. Combinado con una parte superior de malla de ingeniería liviana para una transpirabilidad y elasticidad impresionantes, esta zapatilla para correr de primera calidad está diseñada para ser su entrenador diario.','a entresuela Fresh Foam X ofrece nuestra experiencia Fresh Foam más acolchada para una comodidad increíble\n\nLa parte superior presenta una construcción sin costuras para un ajuste y una sensación elegantes\n\nParte superior de tela suave y malla diseñada\n\nSuela de goma integrada\n\nCierre de cordones ajustable para un ajuste personalizado\n\nDrop de 8 mm**\n',3),(19,'Bicicleta Ruta Émonda SL 5 Gris','Es una excelente opción para recorridos de 100 años en terreno montañoso, llanos ventosos y descensos rápidos.',3190000,'Quieres el rendimiento de una bicicleta de carbono ligera y rápida a un precio excelente. Eres un corredor nuevo o un ciclista de carretera dedicado que busca mejorar una bicicleta de aluminio y desea piezas confiables, potencia de frenado confiable y el ahorro de peso y la calidad de conducción de un cuadro de carbono OCLV aerodinámico.','Cuadro 	\n\nCarbono OCLV Serie 500 ultraligero, optimización de tubo de rendimiento Ride Tuned, tubo de dirección cónico, enrutamiento interno, compatible con DuoTrap S, disco de montaje plano, eje pasante de 142x12 mm\nSuspensión delantera 	\n\nÉmonda SL íntegramente de carbono, tubo de dirección perfilado de carbono, enrutamiento de freno interno, disco de soporte plano, eje pasante de 12x100 mm\nAjuste del cuadro 	\n\nH1.5 Race',4),(20,'Tricota Pro Light Tokyo Edition Azul','Traje ciclismo, alta resistencia, ajuste comodo',32990,'La tricota Kross Pro Light TOKYO Edit. cumple con los requisitos más exigentes de los Ciclistas. Bajo peso, excelente ventilación, corte ajustado y gráficas agresivas.','Los bolsillos traseros adicionales permiten llevar los accesorios necesarios.\n\nEdición limitada con motivo de los Juegos Olímpicos TOKIO 2020\n\nMaterial: poliéster',5),(21,'Casco Laki Amarillo Luminoso','Proteccion asegurada, colores deslumbrantes',23990,'Características: Casco con excelente Ventilación para comodidad durante cualquier paseo en bicicleta, su peso liviano proporciona comodidad incluso durante jornadas largas, pads interiores antibacterianos brindan mayor confort incluso cuando las temperaturas son altas, cuenta con bandas reflectantes en la parte posterior para una mayor seguridad,incluye visera.','Ventilación Aire: 28 agujeros\nPeso: Large 221g',5),(22,'RELOJ GPS 500','Reloj deportivo, controla, ritmo, ppm, calorias',139000,'Reloj GPS Kiprun 500 by Coros te permite controlar tus carreras de running y tus sesiones de natación, en bicicleta y de triatlón. 25 horas de autonomía GPS','Con un peso de solo 48 gramos, te olvidarás de que llevas puesto el reloj.\nDimensiones de la caja: 47,20 x 47,20 x 11,8 mm\nTamaño de la pantalla: 1,2 pulgadas 240 x 240 (64 colores)',6),(23,'TRAJE SURF SHORTY MUJER 100 NEGRO NEOPRENO 1,5 MM','Traje neopreno, surf mujer ',22000,'Nosotras, surfistas de todos los niveles, diseñamos este shorty para la surfista de nivel iniciación que practica en la espuma de las olas','Para elegir un traje de surf, el criterio más importante es la temperatura del agua.La temperatura del agua varía según los lugares y la época del año.Asegúrate siempre de que la temperatura del agua corresponde con el rango de temperaturas recomendado:Aguas de más de 20 °C.\nAguas entre 17 y 22 °C.\nAguas entre 12 y 17 °C.\nAguas entre 7 y 12 °C.',7);
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
INSERT INTO `base_products_categories` VALUES (1,1),(3,1),(4,1),(5,1),(6,1),(7,1),(22,1),(19,2),(20,2),(21,2),(22,2),(22,3),(23,3),(22,4),(19,5),(20,6),(1,7),(3,7),(4,7),(5,7),(6,7),(7,7),(21,8),(23,9),(3,10),(5,10),(1,11),(4,11),(6,11),(7,11),(23,11);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brands`
--

LOCK TABLES `brands` WRITE;
/*!40000 ALTER TABLE `brands` DISABLE KEYS */;
INSERT INTO `brands` VALUES (1,'Nike'),(2,'Adidas'),(3,'New Balance'),(4,'Trek'),(5,'Kross'),(6,'Kiprun'),(7,'Olaian');
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
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carts`
--

LOCK TABLES `carts` WRITE;
/*!40000 ALTER TABLE `carts` DISABLE KEYS */;
INSERT INTO `carts` VALUES (41,488950,1,40,5),(42,0,1,41,0),(43,0,1,42,0),(44,0,1,NULL,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color_variant_product_images`
--

LOCK TABLES `color_variant_product_images` WRITE;
/*!40000 ALTER TABLE `color_variant_product_images` DISABLE KEYS */;
INSERT INTO `color_variant_product_images` VALUES (1,'https://sparta.cl/media/catalog/product/z/a/zapatillas-running-mujer-nike-downshifter-13-blanca-lateral-interior.png?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',1),(6,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-1080-v13-azul-marino-superior.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',4),(7,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-fresh-foam-x-vongo-v6-negra-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',5),(8,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-880-v14-azul-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',6),(9,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-880-v14-negra-superior.png?quality=80&bg-color=255,255,255&fit=bounds&height=90&width=90&canvas=90:90',7),(10,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2a35abb799174437a80d99e2e8958b1c_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Verde_IG6445_HM3_hover.jpg',9),(11,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2b613a79d46d43af859cf9dfc86318d4_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Negro_IG6439_HM5.jpg',8),(12,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/cda54fcc501e4e76ad7b338dea111591_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Verde_IG6445_HM4.jpg',9),(13,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/a2f4b3fcc7014f67bbcbb53c3ee26d3a_9366/Zapatillas_Adizero_Boston_12_Turquesa_ID6901_HM1.jpg',11),(14,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/9830b8efb0fe46bea873a7c8f1f765db_9366/Zapatillas_Adizero_Boston_12_Beige_IG3325_HM1.jpg',10),(15,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/af042b42376e4f6ba3d83eacbf5e15d6_9366/Zapatillas_Adizero_Boston_12_Turquesa_ID6901_HM3_hover.jpg',11),(16,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-evoz-v3-negra-superior_2.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',12),(17,'https://sparta.cl/media/catalog/product/b/i/bicicleta-ruta-trek-emonda-sl-5-gris-2023.png?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',NULL),(18,'https://www.ibikes.cl/wp-content/uploads/2020/06/T4COD100005MBK-768x768.jpg',24),(19,'https://www.ibikes.cl/wp-content/uploads/2016/09/T4CKS000008MLZ-e1531930958992-cuadro.jpg',25),(20,'https://www.ibikes.cl/wp-content/uploads/2016/09/T4CKS000008MPI-420x420-1-768x768.jpg',26),(21,'https://www.ibikes.cl/wp-content/uploads/2016/09/LAKI-FLUOR-768x768.jpg',27);
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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color_variant_products`
--

LOCK TABLES `color_variant_products` WRITE;
/*!40000 ALTER TABLE `color_variant_products` DISABLE KEYS */;
INSERT INTO `color_variant_products` VALUES (1,1,2),(4,3,4),(5,3,3),(6,4,4),(7,4,3),(8,5,3),(9,5,5),(10,6,7),(11,6,5),(12,7,3),(23,19,1),(24,20,4),(25,21,4),(26,21,7),(27,21,8),(28,22,1),(29,23,1);
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
INSERT INTO `colors` VALUES (1,'NoColor',''),(2,'Blanco','#f8fbff'),(3,'Negro',' #212f3d '),(4,'Azul',' #7fb3d5 '),(5,'Verde',' #a9dfbf '),(6,'Rojo',' #f1948a '),(7,'Rosado',' #f5b7b1 '),(8,'Amarillo',' #f9e79f '),(9,'',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directions`
--

LOCK TABLES `directions` WRITE;
/*!40000 ALTER TABLE `directions` DISABLE KEYS */;
INSERT INTO `directions` VALUES (1,'Temuco','Pratt','1232',2),(2,'Temuco','Rodrigues','123423',1),(3,'Cunco','Ohiggins','422',1),(4,'posoamotnoe','la siempre p','1232',3);
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
  `color_variant_product_id` int DEFAULT NULL,
  `size_id` int DEFAULT NULL,
  `img` varchar(1000) DEFAULT NULL,
  `base_product_id` int DEFAULT NULL,
  `name` varchar(500) DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`final_product_id`),
  KEY `fk_final_products_1_idx` (`size_id`),
  KEY `fk_final_products_2_idx` (`color_variant_product_id`),
  CONSTRAINT `fk_final_products_1` FOREIGN KEY (`size_id`) REFERENCES `sizes` (`size_id`),
  CONSTRAINT `fk_final_products_2` FOREIGN KEY (`color_variant_product_id`) REFERENCES `color_variant_products` (`color_variant_product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `final_products`
--

LOCK TABLES `final_products` WRITE;
/*!40000 ALTER TABLE `final_products` DISABLE KEYS */;
INSERT INTO `final_products` VALUES (1,97,62990,1,44,'https://sparta.cl/media/catalog/product/z/a/zapatillas-running-mujer-nike-downshifter-13-blanca-lateral-interior.png?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',1,'Zapatillas Running Mujer Downshifter 13','Nike','Blanco'),(2,100,149990,4,49,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-1080-v13-azul-marino-superior.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',3,'Zapatillas Running Hombre 1080 V13 ','New Balance','Azul'),(3,100,149990,4,50,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-1080-v13-azul-marino-superior.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',3,'Zapatillas Running Hombre 1080 V13 ','New Balance','Azul'),(4,98,149990,5,44,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-fresh-foam-x-vongo-v6-negra-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',3,'Zapatillas Running Hombre 1080 V13 ','New Balance','Negro'),(5,100,99990,6,43,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-880-v14-azul-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',4,'Zapatillas Running Mujer 880 v14','New Balance','Azul'),(6,100,99990,6,42,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-880-v14-azul-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',4,'Zapatillas Running Mujer 880 v14','New Balance','Azul'),(7,99,99990,6,44,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-880-v14-azul-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',4,'Zapatillas Running Mujer 880 v14','New Balance','Azul'),(8,100,99990,6,45,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-880-v14-azul-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',4,'Zapatillas Running Mujer 880 v14','New Balance','Azul'),(9,100,99990,6,46,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-hombre-new-balance-880-v14-azul-lateral.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',4,'Zapatillas Running Mujer 880 v14','New Balance','Azul'),(10,100,99990,7,45,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-880-v14-negra-superior.png?quality=80&bg-color=255,255,255&fit=bounds&height=90&width=90&canvas=90:90',4,'Zapatillas Running Mujer 880 v14','New Balance','Negro'),(11,100,99990,7,49,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-880-v14-negra-superior.png?quality=80&bg-color=255,255,255&fit=bounds&height=90&width=90&canvas=90:90',4,'Zapatillas Running Mujer 880 v14','New Balance','Negro'),(12,100,99990,7,48,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-880-v14-negra-superior.png?quality=80&bg-color=255,255,255&fit=bounds&height=90&width=90&canvas=90:90',4,'Zapatillas Running Mujer 880 v14','New Balance','Negro'),(13,30,229990,8,46,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2b613a79d46d43af859cf9dfc86318d4_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Negro_IG6439_HM5.jpg',5,'Zapatillas ADIZERO ADIOS PRO 3','Adidas','Negro'),(14,30,229990,8,48,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2b613a79d46d43af859cf9dfc86318d4_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Negro_IG6439_HM5.jpg',5,'Zapatillas ADIZERO ADIOS PRO 3','Adidas','Negro'),(15,30,229990,8,52,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2b613a79d46d43af859cf9dfc86318d4_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Negro_IG6439_HM5.jpg',5,'Zapatillas ADIZERO ADIOS PRO 3','Adidas','Negro'),(16,50,229990,9,41,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2a35abb799174437a80d99e2e8958b1c_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Verde_IG6445_HM3_hover.jpg',5,'Zapatillas ADIZERO ADIOS PRO 3','Adidas','Verde'),(17,50,229990,9,43,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2a35abb799174437a80d99e2e8958b1c_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Verde_IG6445_HM3_hover.jpg',5,'Zapatillas ADIZERO ADIOS PRO 3','Adidas','Verde'),(18,50,229990,9,44,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2a35abb799174437a80d99e2e8958b1c_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Verde_IG6445_HM3_hover.jpg',5,'Zapatillas ADIZERO ADIOS PRO 3','Adidas','Verde'),(19,49,229990,9,47,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2a35abb799174437a80d99e2e8958b1c_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Verde_IG6445_HM3_hover.jpg',5,'Zapatillas ADIZERO ADIOS PRO 3','Adidas','Verde'),(20,50,229990,9,48,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2a35abb799174437a80d99e2e8958b1c_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Verde_IG6445_HM3_hover.jpg',5,'Zapatillas ADIZERO ADIOS PRO 3','Adidas','Verde'),(21,50,229990,9,49,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2a35abb799174437a80d99e2e8958b1c_9366/Zapatillas_ADIZERO_ADIOS_PRO_3_Verde_IG6445_HM3_hover.jpg',5,'Zapatillas ADIZERO ADIOS PRO 3','Adidas','Verde'),(22,70,149990,10,42,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/9830b8efb0fe46bea873a7c8f1f765db_9366/Zapatillas_Adizero_Boston_12_Beige_IG3325_HM1.jpg',6,'Zapatillas Adizero Boston 12','Adidas','Rosado'),(23,70,149990,10,45,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/9830b8efb0fe46bea873a7c8f1f765db_9366/Zapatillas_Adizero_Boston_12_Beige_IG3325_HM1.jpg',6,'Zapatillas Adizero Boston 12','Adidas','Rosado'),(24,69,149990,10,48,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/9830b8efb0fe46bea873a7c8f1f765db_9366/Zapatillas_Adizero_Boston_12_Beige_IG3325_HM1.jpg',6,'Zapatillas Adizero Boston 12','Adidas','Rosado'),(25,70,149990,10,43,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/9830b8efb0fe46bea873a7c8f1f765db_9366/Zapatillas_Adizero_Boston_12_Beige_IG3325_HM1.jpg',6,'Zapatillas Adizero Boston 12','Adidas','Rosado'),(26,99,149990,11,43,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/a2f4b3fcc7014f67bbcbb53c3ee26d3a_9366/Zapatillas_Adizero_Boston_12_Turquesa_ID6901_HM1.jpg',6,'Zapatillas Adizero Boston 12','Adidas','Verde'),(27,100,149990,11,45,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/a2f4b3fcc7014f67bbcbb53c3ee26d3a_9366/Zapatillas_Adizero_Boston_12_Turquesa_ID6901_HM1.jpg',6,'Zapatillas Adizero Boston 12','Adidas','Verde'),(28,100,149990,11,37,'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/a2f4b3fcc7014f67bbcbb53c3ee26d3a_9366/Zapatillas_Adizero_Boston_12_Turquesa_ID6901_HM1.jpg',6,'Zapatillas Adizero Boston 12','Adidas','Verde'),(29,50,69990,12,42,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-evoz-v3-negra-superior_2.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',7,'Zapatillas Running Mujer Evoz V3 ','New Balance','Negro'),(30,50,69990,12,43,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-evoz-v3-negra-superior_2.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',7,'Zapatillas Running Mujer Evoz V3 ','New Balance','Negro'),(31,50,69990,12,42,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-evoz-v3-negra-superior_2.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',7,'Zapatillas Running Mujer Evoz V3 ','New Balance','Negro'),(32,50,69990,12,45,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-evoz-v3-negra-superior_2.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',7,'Zapatillas Running Mujer Evoz V3 ','New Balance','Negro'),(33,50,69990,12,47,'https://newbalance.cl/media/catalog/product/z/a/zapatillas-running-mujer-new-balance-evoz-v3-negra-superior_2.png?quality=80&bg-color=255,255,255&fit=bounds&height=650&width=650&canvas=650:650',7,'Zapatillas Running Mujer Evoz V3 ','New Balance','Negro'),(35,9,3190000,23,28,'https://sparta.cl/media/catalog/product/b/i/bicicleta-ruta-trek-emonda-sl-5.png?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550',19,'Bicicleta Ruta Émonda SL 5 Gris','Trek','NoColor'),(36,5,32990,24,30,'https://www.ibikes.cl/wp-content/uploads/2020/06/T4COD100005MBK-768x768.jpg',20,'Tricota Pro Light Tokyo Edition Azul','Kross','Azul'),(37,5,32990,24,34,'https://www.ibikes.cl/wp-content/uploads/2020/06/T4COD100005MBK-768x768.jpg',20,'Tricota Pro Light Tokyo Edition Azul','Kross','Azul'),(38,9,32990,24,32,'https://www.ibikes.cl/wp-content/uploads/2020/06/T4COD100005MBK-768x768.jpg',20,'Tricota Pro Light Tokyo Edition Azul','Kross','Azul'),(39,39,23990,25,31,'https://www.ibikes.cl/wp-content/uploads/2016/09/LAKI-FLUOR-768x768.jpg',21,'Casco Laki Amarillo Luminoso','Kross','Azul'),(40,50,23990,25,30,'https://www.ibikes.cl/wp-content/uploads/2016/09/LAKI-FLUOR-768x768.jpg',21,'Casco Laki Amarillo Luminoso','Kross','Azul'),(41,11,23990,26,30,'https://www.ibikes.cl/wp-content/uploads/2016/09/LAKI-FLUOR-768x768.jpg',21,'Casco Laki Amarillo Luminoso','Kross','Rosado'),(42,20,19990,27,33,'https://www.ibikes.cl/wp-content/uploads/2016/09/LAKI-FLUOR-768x768.jpg',21,'Casco Laki Amarillo Luminoso','Kross','Amarillo'),(43,99,139000,28,28,'https://contents.mediadecathlon.com/p2141791/k$a63545fa07fe1fc241eae60df6fa68fe/reloj-gps-500.jpg?format=auto&quality=40&f=800x800',22,'RELOJ GPS 500','Kiprun','NoColor'),(44,24,22000,29,32,'https://contents.mediadecathlon.com/p1773557/k$850fb437c333261f4d2cc684bb4f6232/traje-surf-corto-100-neopren-15-mm-mujer-negro.jpg?format=auto&quality=40&f=800x800',23,'TRAJE SURF SHORTY MUJER 100 NEGRO NEOPRENO 1,5 MM','Olaian','NoColor'),(45,9,22000,29,30,'https://contents.mediadecathlon.com/p1773557/k$850fb437c333261f4d2cc684bb4f6232/traje-surf-corto-100-neopren-15-mm-mujer-negro.jpg?format=auto&quality=40&f=800x800',23,'TRAJE SURF SHORTY MUJER 100 NEGRO NEOPRENO 1,5 MM','Olaian','NoColor');
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
  `originalquantity` int DEFAULT NULL,
  PRIMARY KEY (`ordered_product_id`),
  KEY `asdf_idx` (`cart_id`),
  KEY `fk_ordered_products_2_idx` (`final_product_id`),
  CONSTRAINT `fk_ordered_products_1` FOREIGN KEY (`cart_id`) REFERENCES `carts` (`cart_id`),
  CONSTRAINT `fk_ordered_products_2` FOREIGN KEY (`final_product_id`) REFERENCES `final_products` (`final_product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordered_products`
--

LOCK TABLES `ordered_products` WRITE;
/*!40000 ALTER TABLE `ordered_products` DISABLE KEYS */;
INSERT INTO `ordered_products` VALUES (138,3,41,1,3),(139,2,41,4,2),(140,0,42,35,1),(141,0,42,43,1),(142,0,42,39,1),(143,0,43,22,4),(144,0,43,38,3);
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
  `user_id` int DEFAULT NULL,
  `cart_id` int DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`sale_id`),
  KEY `fk_sales_1_idx` (`direction_id`),
  CONSTRAINT `fk_sales_1` FOREIGN KEY (`direction_id`) REFERENCES `directions` (`direction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (40,'2024-07-29',2,1,41,'Realizada','rodrigo'),(41,'2024-07-29',3,1,42,'Anulada','rodrigo'),(42,'2024-07-29',2,1,43,'Anulada','rodrigo');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'RODRIGO','ayelef','rodr1alex27@gmail.com','Rodrigo','$2a$10$4NStmMOKRcTmjY17U7JDbefB/xqvh4g2fjIbUTVQf715sLdS1Ryxq'),(2,'juan','perez','jperez@gmail.com','jperez','$2a$10$cDGSbFDdE8k4CNtPxYQFe.J23T0mslb6Dhjsbax/0AzEi8nkDIbpK'),(3,'ronado','fuentes','rfuentes@gmail.com','rfuentes','$2a$10$zfy1nz93zG5ObuHi6i8jru/WRGEXYV9zsnvp0WJlnttWrCoAbcD96');
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
INSERT INTO `users_roles` VALUES (1,1),(2,1),(3,1),(1,2);
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

-- Dump completed on 2024-08-03 22:39:04
