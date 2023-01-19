package kz.nearbygems.grpc;

import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

  public static void main(String[] args) {

    final var channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                                             .usePlaintext()
                                             .build();

    final var stub = HelloServiceGrpc.newBlockingStub(channel);

    final var request = HelloRequest.newBuilder()
                                    .setFirstName("Bergen")
                                    .setLastName("Asym")
                                    .build();

    final var helloResponse = stub.hello(request);

    System.out.println("Greeting: " + helloResponse.getGreeting());

    channel.shutdown();
  }

}
