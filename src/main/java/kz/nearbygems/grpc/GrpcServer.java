package kz.nearbygems.grpc;

import io.grpc.ServerBuilder;
import kz.nearbygems.grpc.service.HelloServiceImpl;
import lombok.SneakyThrows;

public class GrpcServer {

  @SneakyThrows
  public static void main(String[] args) {

    final var service = HelloServiceImpl.builder().build();

    final var server = ServerBuilder
        .forPort(8080)
        .addService(service).build();

    server.start();
    server.awaitTermination();
  }

}
