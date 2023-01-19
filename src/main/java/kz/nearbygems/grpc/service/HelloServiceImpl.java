package kz.nearbygems.grpc.service;

import io.grpc.stub.StreamObserver;
import kz.nearbygems.grpc.HelloRequest;
import kz.nearbygems.grpc.HelloResponse;
import kz.nearbygems.grpc.HelloServiceGrpc;
import lombok.Builder;

@Builder
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

  @Override
  public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

    final var greeting = "Hello, " +
                         request.getFirstName() +
                         " " +
                         request.getLastName();

    final var response = HelloResponse.newBuilder()
                                      .setGreeting(greeting)
                                      .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

}
