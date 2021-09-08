import io.grpc.Server;
import io.grpc.ServerBuilder;
import user.UserService;

import java.io.IOException;

public class GRPCServer {

  public static void main(String[] args) throws IOException, InterruptedException {
    // Create new instance of server
    Server server = ServerBuilder
        .forPort(9090).addService(new UserService()).build();

    server.start();

    System.out.println("GRPC server started at port " +server.getPort());

    server.awaitTermination();
  }
}
