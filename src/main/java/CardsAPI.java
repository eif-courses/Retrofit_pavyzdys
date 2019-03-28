import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface CardsAPI {
    @GET("Cardss")
    @Headers({"X-Mashape-Key:x0hUDU7DhCmshRVICp9yc0BE0LQtp1CVXM0jsn9p2F2pQnLPbH",
            "X-Mashape-Host:omgvamp-hearthstone-v1.p.mashape.com"})
    Call<List<Cards>> getCardss();

    @GET("cards")
    @Headers({"X-RapidAPI-Key:VmRNIaPTbVmshBpcQpdCRb3GO8wJp15FbNDjsnWEHq2yExuF3w",
            "X-RapidAPI-Host:omgvamp-hearthstone-v1.p.rapidapi.com"})
    Call<Cards> getCards();

    @GET("cards/{name}")
    @Headers({"X-RapidAPI-Key:VmRNIaPTbVmshBpcQpdCRb3GO8wJp15FbNDjsnWEHq2yExuF3w",
            "X-RapidAPI-Host:omgvamp-hearthstone-v1.p.rapidapi.com"})
    Call<List<Card>> getSingleCard(@Path("name") String name);
}
