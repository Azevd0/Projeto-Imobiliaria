FROM ghcr.io/graalvm/native-image-community:21 AS build
WORKDIR /app
COPY . .
RUN ./mvnw native:compile -Pnative -DskipTests

FROM ubuntu:jammy
WORKDIR /app
COPY --from=build /app/target/desafio-imobiliaria .
EXPOSE 8080
CMD ["./desafio-imobiliaria"]
