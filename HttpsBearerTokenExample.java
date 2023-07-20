import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpsBearerTokenExample {

    public static void main(String[] args) {
        String token = "seu_token_bearer_aqui";
        String url = "https://exemplo.com/api/recurso"; // substitua pela URL da API que você deseja chamar

        try {
            String response = sendGetRequestWithBearerToken(url, token);
            System.out.println("Resposta da API: " + response);
        } catch (IOException e) {
            System.err.println("Erro ao realizar a chamada HTTPS: " + e.getMessage());
        }
    }

    private static String sendGetRequestWithBearerToken(String url, String token) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpUriRequest request = new HttpGet(url);
        request.addHeader("Authorization", "Bearer " + token);

        HttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            return EntityUtils.toString(entity);
        }

        return null;
    }
}
