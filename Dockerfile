FROM eclipse-temurin:24-jdk-alpine

LABEL author="Aristote Iziri"
LABEL description="Essaie d'un API REST avec Spring Boot et JPA"

WORKDIR /app

# Copier le fichier JAR de l'application dans le conteneur
COPY target/gestion_produit.jar ./gestion_produit.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 8082

CMD ["java", "-jar", "gestion_produit.jar"]