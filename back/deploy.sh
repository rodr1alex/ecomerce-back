#!/bin/bash

# ============================================================
# RELLENA ESTAS VARIABLES ANTES DE EJECUTAR
# ============================================================
APP_NAME="api-tienda"
IMAGE_NAME="ecommerce-api"
IMAGE_TAG="20260512"

PROJECT_DIR="/home/ubuntu/api/ecomerce-back/back"

DB_URL="jdbc:mysql://ENDPOINT_RDS:3306/tienda"
DB_USERNAME="USUARIO_RDS"
DB_PASSWORD="PASSWORD_RDS"
# ============================================================

echo ">>> Entrando al directorio del proyecto..."
cd $PROJECT_DIR

echo ">>> Pulling último código desde git..."
git fetch --all
git reset --hard origin/main

echo ">>> Deteniendo contenedor anterior..."
sudo docker stop $APP_NAME 2>/dev/null || true
sudo docker rm $APP_NAME 2>/dev/null || true

echo ">>> Eliminando imagen anterior..."
sudo docker rmi $IMAGE_NAME:$IMAGE_TAG 2>/dev/null || true

echo ">>> Construyendo nueva imagen..."
sudo docker build --no-cache -t $IMAGE_NAME:$IMAGE_TAG $PROJECT_DIR

echo ">>> Levantando contenedor nuevo..."
sudo docker run -d \
  --name $APP_NAME \
  --restart unless-stopped \
  -p 8080:8080 \
  -e DB_URL=$DB_URL \
  -e DB_USERNAME=$DB_USERNAME \
  -e DB_PASSWORD=$DB_PASSWORD \
  $IMAGE_NAME:$IMAGE_TAG

echo ">>> Esperando arranque (15s)..."
sleep 15

echo ">>> Estado del contenedor:"
sudo docker ps --filter "name=$APP_NAME" --format "table {{.Names}}\t{{.Image}}\t{{.Status}}"

echo ">>> Logs de arranque:"
sudo docker logs $APP_NAME --tail 50
