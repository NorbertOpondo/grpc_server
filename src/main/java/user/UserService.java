package user;

import com.norbert.grpc.User;
import com.norbert.grpc.userGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends userGrpc.userImplBase {
  @Override
  public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
    System.out.println("-- Inside login --");
    System.out.println("request username = " + request.getUsername());
    System.out.println("request password = " + request.getPassword());

    User.APIResponse.Builder response = User.APIResponse.newBuilder();


    if (request.getUsername().equals(request.getPassword())) {
      response.setResponseCode(0).setResponseMessage("SUCCESS");
    } else {
      response.setResponseCode(100).setResponseMessage("ERROR");
    }

    responseObserver.onNext(response.build());
    responseObserver.onCompleted();
  }

  @Override
  public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {

  }
}
