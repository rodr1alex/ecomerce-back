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
-- Table structure for table `base_product_images`
--

DROP TABLE IF EXISTS `base_product_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `base_product_images` (
  `base_product_image_id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(500) DEFAULT NULL,
  `base_product_id` int DEFAULT NULL,
  PRIMARY KEY (`base_product_image_id`),
  KEY `fk_base_product_images_1_idx` (`base_product_id`),
  CONSTRAINT `fk_base_product_images_1` FOREIGN KEY (`base_product_id`) REFERENCES `base_products` (`base_product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_product_images`
--

LOCK TABLES `base_product_images` WRITE;
/*!40000 ALTER TABLE `base_product_images` DISABLE KEYS */;
INSERT INTO `base_product_images` VALUES (1,'https://http2.mlstatic.com/D_NQ_NP_936709-MLA51656456998_092022-O.webp',1),(3,'https://www.mamanoleas.com/wp-content/uploads/2018/03/20180312_154808-1024x751.jpg',1),(4,'https://static.dafiti.cl/p/nike-9370-16406-1-zoom.jpg',NULL),(5,'https://c8.alamy.com/compes/dx2jwb/nino-usando-zapatos-nike-fluorescentes-el-foro-romano-roma-italia-dx2jwb.jpg',NULL),(6,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSorCAsB0xWoxZudy4Pg-W-zWgeyr95Tv2ePQ&s',NULL),(7,'https://static.dafiti.cl/p/nike-9370-16406-1-zoom.jpg',5),(8,'https://c8.alamy.com/compes/dx2jwb/nino-usando-zapatos-nike-fluorescentes-el-foro-romano-roma-italia-dx2jwb.jpg',5),(9,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSorCAsB0xWoxZudy4Pg-W-zWgeyr95Tv2ePQ&s',5),(10,'https://static.dafiti.cl/p/nike-9370-16406-1-zoom.jpg',6),(11,'https://c8.alamy.com/compes/dx2jwb/nino-usando-zapatos-nike-fluorescentes-el-foro-romano-roma-italia-dx2jwb.jpg',6),(12,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSorCAsB0xWoxZudy4Pg-W-zWgeyr95Tv2ePQ&s',6),(13,NULL,NULL),(14,NULL,NULL),(15,'https://www.gob.mx/cms/uploads/article/main_image/104995/WhatsApp_Image_2021-02-12_at_11.44.36_AM.jpeg',4),(18,'https://imgs.search.brave.com/idPdwc1f-iLQQbGw6_O8Mmarfwft6-H60C6Vh2qoClU/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL0kv/NTFOZXJEV0U3ekwu/anBn',NULL),(19,'https://imgs.search.brave.com/hexdNzb4qoXL5nDIWeCbee19Cb9cF03ciE_ADwHRitQ/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5hbGx0cmlja3Mu/Y29tL21lZGl1bS8y/MjcyMjIwNjJiMTlj/ODM3OTQzZTMuMzQx/Njk4MjQ',NULL),(23,'https://imgs.search.brave.com/P8WtDWbI55En_rxFkpfilimefzGwjR5Y36kTxdmLEtM/rs:fit:860:0:0/g:ce/aHR0cHM6Ly93d3cu/bWlzdGVycnVubmlu/Zy5jb20vbWVkaWEv/c3JjL05pa2UtYnJh/bmQtbWVudS5qcGc',7),(24,'https://imgs.search.brave.com/_nT3X7r8dmcIG6u8nwvS9UZm8mQAAqR4ZHaKJsK2smg/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9pbWdj/ZW50YXVyby1hLmFr/YW1haWhkLm5ldC8x/MzY2eDEzNjYvOTE1/NTE3MDEuanBn',7),(25,'https://imgs.search.brave.com/1ltv1nPAX3EBGYkwaHSdkDIENdfdsSwQHzAfmz1UA6w/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL0kv/ODFRTkJsWFRyckwu/anBn',7),(26,'https://www.onelastrep.cl/cdn/shop/files/Proteina-Whey-Concentrate-ProSupps-5-Lb-Chocolate-Ice-Cream-3_1200x.jpg?v=1711416398',2),(27,'https://bodysanctuary.twic.pics/https://www.bodysanctuary.com.mx/wp-content/uploads/2018/03/esteroides-en-hombres.jpg?twic=v1/cover=1600:1066/resize=760/max=2000',3);
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
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL,
  `base_price` int DEFAULT NULL,
  `chars` varchar(1000) DEFAULT NULL,
  `specs` varchar(300) DEFAULT NULL,
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
INSERT INTO `base_products` VALUES (1,'condon xl','condon para negrillo',1300,'condon extraresistente para negro, espermicida 99.9%','largo:22cm;resistencia:40kg/m;',3),(2,'Whey polvo chocolate','Proteina sabor cholate, 30 gramos',30000,'Proteina de gran calidad extra sabrosa, con creatina y vitaminas del complejo B','peso:1000gm;sabor:chocolate;tipo:whey; ',4),(3,'Gruowup xxl','Anabolizante sabor vainilla',150000,'Hormona de gran prestacion, anabolizante por excelencia ','15 sobres de 1mg por dosis, incluye jeringa',5),(4,'zapatilla pa correr','La mehoresl pal choreo',109990,'Zapatillas de gran resistencia y potencia','kilometraje:10k;peso:300gr;resistente al agua;fluorescentes',1),(5,'zapatilla pa xorear','La mehoresl pal choreo',19990,'Zapatillas de gran resistencia y potencia','kilometraje:10k;peso:300gr;resistente al agua;fluorescentes',2),(6,'Zapatilla maraton 42k buenas','La mehoresl pal choreo',119990,'Zapatillas de gran resistencia y potencia','kilometraje:10k;peso:300gr;resistente al agua;fluorescentes',6),(7,'Camiseta running hombre','Camiseta algodon perfecta para entrenamiento en frio',24990,'Camiseta de entrenamiento de alto rendimiento, progete en climas frios manteniendo transpirabilidad e impermeabilidad, tambien es apta para climas lluviosos, facil de lavar y muy atractiva con la feminas','Composicion algodon:0% sintetico:10000%; peso:1350Gr;',1);
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
INSERT INTO `base_products_categories` VALUES (2,1),(3,1),(1,2),(1,3),(3,3),(4,4),(5,4),(6,4),(7,5),(7,6),(7,8);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brands`
--

LOCK TABLES `brands` WRITE;
/*!40000 ALTER TABLE `brands` DISABLE KEYS */;
INSERT INTO `brands` VALUES (1,'Nike'),(2,'Adidas'),(3,'Durex'),(4,'MyProtein'),(5,'MySteroid'),(6,'New Balance');
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carts`
--

LOCK TABLES `carts` WRITE;
/*!40000 ALTER TABLE `carts` DISABLE KEYS */;
INSERT INTO `carts` VALUES (1,0,1,1,NULL),(2,999,1,2,NULL),(3,79970,1,3,NULL),(4,239880,1,4,NULL),(5,9980,1,6,NULL),(6,14980,1,7,NULL),(7,0,1,8,NULL),(8,0,1,9,NULL),(9,399800,1,11,NULL),(10,0,2,10,NULL),(11,NULL,2,NULL,NULL),(12,699750,2,12,NULL),(13,0,1,13,NULL),(15,324870,1,NULL,13);
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
INSERT INTO `carts_ordered_product_list` VALUES (1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Suplementacion'),(2,'Cuidado'),(3,'Anabolizantes'),(4,'Zapatos'),(5,'Running'),(6,'Hombre'),(7,'Mujer'),(8,'Ropa');
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
  `url` varchar(500) DEFAULT NULL,
  `color_variant_product_id` int DEFAULT NULL,
  PRIMARY KEY (`color_variant_product_image_id`),
  KEY `fk_color_variant_product_images_1_idx` (`color_variant_product_id`),
  CONSTRAINT `fk_color_variant_product_images_1` FOREIGN KEY (`color_variant_product_id`) REFERENCES `color_variant_products` (`color_variant_product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color_variant_product_images`
--

LOCK TABLES `color_variant_product_images` WRITE;
/*!40000 ALTER TABLE `color_variant_product_images` DISABLE KEYS */;
INSERT INTO `color_variant_product_images` VALUES (1,'https://previews.123rf.com/images/valzann/valzann1611/valzann161100504/65970259-cond%C3%B3n-negro-aislado-en-el-fondo-blanco-closeup.jpg',1),(2,'https://www.shutterstock.com/image-photo/black-condom-dressed-on-banana-260nw-2246904311.jpg',1),(3,'https://static-pu.salcobrandonline.cl/images/spree/images/45995/attachments/large/product-images_2034094.jpg?1660253878',1),(4,'https://media.biobiochile.cl/wp-content/uploads/2022/10/social-preservativos-defectuosos-isp-1200x633.jpg',2),(5,'https://static.salcobrandonline.cl/spree/products/86118/small/9150855-1.jpg?1672367562',2),(6,'https://allmedicaldevices.cl/cdn/shop/products/plain.png?v=1646255416',2),(7,'https://http2.mlstatic.com/D_NQ_NP_899298-MLC54961265720_042023-O.webp',NULL),(8,'https://down-cl.img.susercontent.com/file/faf15dc86e0c17698130f1a504bcabae',NULL),(9,'https://media.revistagq.com/photos/5ece4d7e4b4886295b6a341b/16:9/w_3296,h_1854,c_limit/GettyImages-911210622.jpg',NULL),(10,'https://http2.mlstatic.com/D_NQ_NP_899298-MLC54961265720_042023-O.webp',NULL),(11,'https://down-cl.img.susercontent.com/file/faf15dc86e0c17698130f1a504bcabae',NULL),(12,'https://media.revistagq.com/photos/5ece4d7e4b4886295b6a341b/16:9/w_3296,h_1854,c_limit/GettyImages-911210622.jpg',NULL),(13,'https://http2.mlstatic.com/D_NQ_NP_899298-MLC54961265720_042023-O.webp',3),(14,'https://down-cl.img.susercontent.com/file/faf15dc86e0c17698130f1a504bcabae',3),(15,'https://media.revistagq.com/photos/5ece4d7e4b4886295b6a341b/16:9/w_3296,h_1854,c_limit/GettyImages-911210622.jpg',3),(16,'https://http2.mlstatic.com/D_NQ_NP_899298-MLC54961265720_042023-O.webp',4),(17,'https://down-cl.img.susercontent.com/file/faf15dc86e0c17698130f1a504bcabae',4),(18,'https://media.revistagq.com/photos/5ece4d7e4b4886295b6a341b/16:9/w_3296,h_1854,c_limit/GettyImages-911210622.jpg',4),(19,'https://http2.mlstatic.com/D_NQ_NP_899298-MLC54961265720_042023-O.webp',5),(20,'https://down-cl.img.susercontent.com/file/faf15dc86e0c17698130f1a504bcabae',5),(21,'https://media.revistagq.com/photos/5ece4d7e4b4886295b6a341b/16:9/w_3296,h_1854,c_limit/GettyImages-911210622.jpg',5),(22,'https://http2.mlstatic.com/D_NQ_NP_899298-MLC54961265720_042023-O.webp',NULL),(23,'https://down-cl.img.susercontent.com/file/faf15dc86e0c17698130f1a504bcabae',NULL),(24,'https://media.revistagq.com/photos/5ece4d7e4b4886295b6a341b/16:9/w_3296,h_1854,c_limit/GettyImages-911210622.jpg',NULL),(25,'https://http2.mlstatic.com/D_NQ_NP_899298-MLC54961265720_042023-O.webp',7),(26,'https://down-cl.img.susercontent.com/file/faf15dc86e0c17698130f1a504bcabae',7),(27,'https://media.revistagq.com/photos/5ece4d7e4b4886295b6a341b/16:9/w_3296,h_1854,c_limit/GettyImages-911210622.jpg',7),(28,'https://http2.mlstatic.com/D_NQ_NP_899298-MLC54961265720_042023-O.webp',8),(29,'https://down-cl.img.susercontent.com/file/faf15dc86e0c17698130f1a504bcabae',8),(31,'https://media.revistagq.com/photos/5ece4d7e4b4886295b6a341b/16:9/w_3296,h_1854,c_limit/GettyImages-911210622.jpg',8),(32,'https://imgs.search.brave.com/Fcltc8eTrITPwzOr_xv1LM76u_DSAUEIspaHJkD0dcA/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL0kv/NDFvVGZlOW1vVUwu/anBn',NULL),(33,'https://imgs.search.brave.com/Fcltc8eTrITPwzOr_xv1LM76u_DSAUEIspaHJkD0dcA/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL0kv/NDFvVGZlOW1vVUwu/anBn',9),(35,'https://imgs.search.brave.com/HilHSspo5OfnYZc5qt8uc1LQ532hEANIQMaK37O5ElM/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9yZXNp/emUuc3ByaW50ZXJj/ZG4uY29tL2YvMjg4/MHgyODgwL3Byb2R1/Y3RzLzAzODEyMjUv/Y2FtaXNldGEtbmlr/ZV8wMzgxMjI1XzAw/XzRfMTIzODk2MTYw/MC5qcGc_dz0yODgw/JnE9NzU',10),(36,'https://imgs.search.brave.com/10JRDEWKLAQH_4-V5Cx6A6rhzw5F5Zc3VJNCkvsYYWQ/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9zdGF0/aWMuZGFmaXRpLmNv/bS5jby9wL25pa2Ut/Mjg0My0yNDczNy0x/LWNhcnQuanBn',10),(37,'https://imgs.search.brave.com/zEGj5pVs8zROjYfYiukEq6sD3ub3qE7oyURimYoYTFE/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9pbWFn/ZXMuc3R5bGlnaHQu/bmV0L2ltYWdlL3Vw/bG9hZC90X3dlYl9w/cm9kdWN0XzMzMHg0/NDBtYXhfbm9iZy9x/X2F1dG86ZWNvLGZf/YXV0by9kYmpwYjYz/bHRzbWJyM2N0cHM3/ei53ZWJw',10),(38,'https://imgs.search.brave.com/2yvZOAKpvtWIkmEEnoEDzCe5q1BOiRkd_OuCV621uc8/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9pbWFn/ZXMuZmFzaGlvbGEu/ZXMvcHJvZHVjdC1s/aXN0LzMwMHg0NTAv/bmlrZS82MTUzNzc3/OTQvcmVhZHktY2Ft/aXNldGEtZGUtZml0/bmVzcy1kcmktZml0/LWNvbi1jcmVtYWxs/ZXJhLWRlLTEtNC1o/b21icmUud2VicA',9);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color_variant_products`
--

LOCK TABLES `color_variant_products` WRITE;
/*!40000 ALTER TABLE `color_variant_products` DISABLE KEYS */;
INSERT INTO `color_variant_products` VALUES (1,1,2),(2,1,3),(3,NULL,3),(4,5,3),(5,5,4),(6,6,3),(7,6,3),(8,2,4),(9,7,2),(10,7,6);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colors`
--

LOCK TABLES `colors` WRITE;
/*!40000 ALTER TABLE `colors` DISABLE KEYS */;
INSERT INTO `colors` VALUES (1,'nocolor',' '),(2,'black','nm-flat-black'),(3,'white','nm-flat-white'),(4,'Blue','nm-flat-blue-500-sm'),(5,'yellow','nm-flat-yellow-500-sm'),(6,'Verde','nm-flat-green-500-sm');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directions`
--

LOCK TABLES `directions` WRITE;
/*!40000 ALTER TABLE `directions` DISABLE KEYS */;
INSERT INTO `directions` VALUES (1,'Temuco','Nueva Extremadura','3238',1);
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
  `final_description` varchar(200) DEFAULT NULL,
  `final_chars` varchar(1000) DEFAULT NULL,
  `final_specs` varchar(200) DEFAULT NULL,
  `color_variant_product_id` int DEFAULT NULL,
  `size_id` int DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `img` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`final_product_id`),
  KEY `fk_final_products_1_idx` (`size_id`),
  KEY `fk_final_products_2_idx` (`color_variant_product_id`),
  CONSTRAINT `fk_final_products_1` FOREIGN KEY (`size_id`) REFERENCES `sizes` (`size_id`),
  CONSTRAINT `fk_final_products_2` FOREIGN KEY (`color_variant_product_id`) REFERENCES `color_variant_products` (`color_variant_product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `final_products`
--

LOCK TABLES `final_products` WRITE;
/*!40000 ALTER TABLE `final_products` DISABLE KEYS */;
INSERT INTO `final_products` VALUES (1,75,19990,NULL,NULL,'Condo para congolenio',1,5,NULL,NULL,NULL),(2,80,29990,NULL,NULL,'Codon para negro deforme',1,6,NULL,NULL,NULL),(3,100,9990,NULL,NULL,'Para chicas pero poderosas',2,2,NULL,NULL,NULL),(4,100,4990,NULL,NULL,'Standart para blanco nomalito',2,3,NULL,NULL,NULL),(5,100,NULL,NULL,NULL,NULL,4,7,NULL,NULL,NULL),(6,200,NULL,NULL,NULL,NULL,4,8,NULL,NULL,NULL),(7,200,NULL,'La mehoresl pal choreo',NULL,NULL,4,10,NULL,NULL,NULL),(8,200,19990,'La mehoresl pal choreo','Zapatillas de gran resistencia y potencia','kilometraje:10k;peso:300gr;resistente al agua;fluorescentes',4,10,NULL,NULL,NULL),(9,200,100000,'La mehoresl pal choreo','Zapatillas de gran resistencia y potencia','kilometraje:10k;peso:300gr;resistente al agua;fluorescentes',4,8,NULL,NULL,NULL),(10,100,24990,'Camiseta algodon perfecta para entrenamiento en frio','Camiseta de entrenamiento de alto rendimiento, progete en climas frios manteniendo transpirabilidad e impermeabilidad, tambien es apta para climas lluviosos, facil de lavar y muy atractiva con la feminas','Composicion algodon:0% sintetico:10000%; peso:1350Gr;',9,4,'Nike','Black','https://imgs.search.brave.com/Fcltc8eTrITPwzOr_xv1LM76u_DSAUEIspaHJkD0dcA/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL0kv/NDFvVGZlOW1vVUwu/anBn'),(11,50,24990,'Camiseta algodon perfecta para entrenamiento en frio','Camiseta de entrenamiento de alto rendimiento, progete en climas frios manteniendo transpirabilidad e impermeabilidad, tambien es apta para climas lluviosos, facil de lavar y muy atractiva con la feminas','Composicion algodon:0% sintetico:10000%; peso:1350Gr;',9,5,'Nike','Black','https://imgs.search.brave.com/Fcltc8eTrITPwzOr_xv1LM76u_DSAUEIspaHJkD0dcA/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL0kv/NDFvVGZlOW1vVUwu/anBn'),(12,50,24990,'Camiseta algodon perfecta para entrenamiento en frio','Camiseta de entrenamiento de alto rendimiento, progete en climas frios manteniendo transpirabilidad e impermeabilidad, tambien es apta para climas lluviosos, facil de lavar y muy atractiva con la feminas','Composicion algodon:0% sintetico:10000%; peso:1350Gr;',10,3,'Nike','Green','https://imgs.search.brave.com/HilHSspo5OfnYZc5qt8uc1LQ532hEANIQMaK37O5ElM/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9yZXNp/emUuc3ByaW50ZXJj/ZG4uY29tL2YvMjg4/MHgyODgwL3Byb2R1/Y3RzLzAzODEyMjUv/Y2FtaXNldGEtbmlr/ZV8wMzgxMjI1XzAw/XzRfMTIzODk2MTYw/MC5qcGc_dz0yODgw/JnE9NzU'),(13,50,24990,'Camiseta algodon perfecta para entrenamiento en frio','Camiseta de entrenamiento de alto rendimiento, progete en climas frios manteniendo transpirabilidad e impermeabilidad, tambien es apta para climas lluviosos, facil de lavar y muy atractiva con la feminas','Composicion algodon:0% sintetico:10000%; peso:1350Gr;',10,4,'Nike','Green','https://imgs.search.brave.com/HilHSspo5OfnYZc5qt8uc1LQ532hEANIQMaK37O5ElM/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9yZXNp/emUuc3ByaW50ZXJj/ZG4uY29tL2YvMjg4/MHgyODgwL3Byb2R1/Y3RzLzAzODEyMjUv/Y2FtaXNldGEtbmlr/ZV8wMzgxMjI1XzAw/XzRfMTIzODk2MTYw/MC5qcGc_dz0yODgw/JnE9NzU'),(14,50,24990,'Camiseta algodon perfecta para entrenamiento en frio','Camiseta de entrenamiento de alto rendimiento, progete en climas frios manteniendo transpirabilidad e impermeabilidad, tambien es apta para climas lluviosos, facil de lavar y muy atractiva con la feminas','Composicion algodon:0% sintetico:10000%; peso:1350Gr;',10,5,'Nike','Green','https://imgs.search.brave.com/HilHSspo5OfnYZc5qt8uc1LQ532hEANIQMaK37O5ElM/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9yZXNp/emUuc3ByaW50ZXJj/ZG4uY29tL2YvMjg4/MHgyODgwL3Byb2R1/Y3RzLzAzODEyMjUv/Y2FtaXNldGEtbmlr/ZV8wMzgxMjI1XzAw/XzRfMTIzODk2MTYw/MC5qcGc_dz0yODgw/JnE9NzU'),(15,20,14990,'Camiseta algodon perfecta para entrenamiento en frio','Camiseta de entrenamiento de alto rendimiento, progete en climas frios manteniendo transpirabilidad e impermeabilidad, tambien es apta para climas lluviosos, facil de lavar y muy atractiva con la feminas','Composicion algodon:0% sintetico:10000%; peso:1350Gr;',10,6,'Nike','Green','https://imgs.search.brave.com/HilHSspo5OfnYZc5qt8uc1LQ532hEANIQMaK37O5ElM/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9yZXNp/emUuc3ByaW50ZXJj/ZG4uY29tL2YvMjg4/MHgyODgwL3Byb2R1/Y3RzLzAzODEyMjUv/Y2FtaXNldGEtbmlr/ZV8wMzgxMjI1XzAw/XzRfMTIzODk2MTYw/MC5qcGc_dz0yODgw/JnE9NzU');
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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordered_products`
--

LOCK TABLES `ordered_products` WRITE;
/*!40000 ALTER TABLE `ordered_products` DISABLE KEYS */;
INSERT INTO `ordered_products` VALUES (1,5,1,4),(2,1,1,3),(3,5,1,2),(11,1,3,1),(12,2,3,2),(13,10,4,1),(14,1,4,2),(15,1,4,3),(16,2,5,4),(17,1,6,4),(18,1,6,3),(34,20,9,1),(35,5,12,1),(36,20,12,2),(43,4,15,10),(45,4,15,13),(46,2,15,14),(47,3,15,10);
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
  PRIMARY KEY (`sale_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (1,'2020-10-10'),(2,'2024-05-12'),(3,'2024-06-18'),(4,'2024-06-18'),(5,'2024-06-19'),(6,'2024-06-19'),(7,'2024-06-19'),(8,'2024-06-19'),(9,'2024-06-19'),(10,'2024-06-19'),(11,'2024-06-19'),(12,'2024-06-19'),(13,'2024-06-27');
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sizes`
--

LOCK TABLES `sizes` WRITE;
/*!40000 ALTER TABLE `sizes` DISABLE KEYS */;
INSERT INTO `sizes` VALUES (1,'XS'),(2,'S'),(3,'M'),(4,'L'),(5,'XL'),(6,'XXL'),(7,'40,5'),(8,'41'),(9,'42'),(10,'43');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'rodrigo','ayelef','rodr1@gmail.com','roro','$2a$10$1OXub8pS/H8SlxE3HJqjTeaZ9xbFPQNvlhcnwRGu3D2ls1XhWenxe'),(2,'alex','huilipan','alex_huilipan@gmail.com','alex1','$2a$10$ZTF8aZUHgEG3/rWq.eHXQOHBnsgTFWq5yVfGOXVKjMP0JhUknkIGe'),(3,'chancho','perez','chancho_perez@gmail.com','chancho1','$2a$10$RNgVSKLaUDWo9wz19UpjLuNb3FdnuIEnTWVMty9/.KP5wGp7mJmWO'),(4,'Rodrigo','Ayelef','rodr1alex27@gmail.com','weonwea','$2a$10$my2VNYkqvn7AeH.P9pxcIOXfVv2wlhM7bEapxm9fLA7Px6sbOV3i.'),(5,'lalo','landa','lalolanda@gmail.com','lalolanda','$2a$10$1RuEAZ.63GJJsIphE2Om2ObE2FuR4Nk6hXf1E4HEr0pNwlgGvQueK'),(6,'harry','potter','hpotter@gmail.com','harry_sucio','$2a$10$W7uF6n8/aRPCks4x1aVQpO9aS0K.RRrekauwq4dmwjI7vQ1/SXwKa'),(7,'Rodrigo','Ayelef','rodr1alex27@gmail.com','weonsio','$2a$10$GVvtEX87dVe4Rmce8ZDe0ep3TY.hR/gEupB2u6r08YlYDLMIxFsbC');
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
INSERT INTO `users_roles` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(1,2),(3,2);
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

-- Dump completed on 2024-07-01 12:07:49
