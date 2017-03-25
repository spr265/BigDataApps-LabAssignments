import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Naga on 13-03-2017.
 */
@WebServlet(name = "ImageService", urlPatterns = "/ImageService")
public class ImageService extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
        String response="";
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        String data = buffer.toString();
        System.out.println(data);
        String output = "";
        JSONObject params = new JSONObject(data);
        JSONObject result = params.getJSONObject("result");
        JSONObject parameters = result.getJSONObject("parameters");
        if (parameters.get("fruits").toString().equals("fruits")) {
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put("https://s-media-cache-ak0.pinimg.com/originals/31/a4/5e/31a45eadae7141704d83816314cce0a8.jpg");
            jsonArray.put("http://votreart.com/wp-content/uploads/2015/07/fruits-and-vegetables-wallpaper-3.jpg");
            jsonArray.put("http://www.hdimageson.com/wp-content/uploads/2016/09/fruit-wallpapers.jpg");
            jsonArray.put("http://www.newhealthadvisor.com/images/1HT18746/fruits_1.jpg");
            jsonArray.put("http://vignette1.wikia.nocookie.net/phobia/images/6/6e/Fruit.jpg/revision/latest?cb=20161116022138");
            jsonArray.put("https://media.mnn.com/assets/images/2016/02/fresh-fruits-market.jpg.653x0_q80_crop-smart.jpg");

            jsonObject.put("data", jsonArray);
            output = jsonObject.toString();
            Data data_ob = Data.getInstance();
            data_ob.setData(output);
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            js.put("speech", "fruits are displayed");
            js.put("displayText", "fruits are displayed");
            js.put("source", "image database");
            response = js.toString();
        }
        else if (parameters.get("fruits").toString().equals("apple")) {
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put("http://www.theayurveda.org/wp-content/uploads/2015/08/Apple-fruit.jpg");
            jsonArray.put("http://iqquotes.com/wp-content/uploads/2015/07/apple-fruit-3.jpg");
            jsonArray.put("http://www.threepullpa.com/data/uploads/3/291963-apple-photo-fruits.jpg");
            jsonArray.put("http://www.opas.org.br/wp-content/uploads/2016/12/macas.jpg");
            jsonArray.put("http://www.clipartbest.com/cliparts/9ip/b6k/9ipb6k5GT.jpeg");
            jsonArray.put("http://www.26fruits.co.uk/images/full-fruit/apple.jpg");
            jsonObject.put("data", jsonArray);
            output = jsonObject.toString();
            Data data_ob = Data.getInstance();
            data_ob.setData(output);
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            js.put("speech", "apples are displayed");
            js.put("displayText", "apples are displayed");
            js.put("source", "image database");
            response = js.toString();
        }
        else if (parameters.get("fruits").toString().equals("cherry")){
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put("http://www.mekatronics.in/cherry-fruits_files/711931.jpg");
            jsonArray.put("http://www.fruitsvege.com/wp-content/uploads/2013/07/cherry-fruit-leaves-red1.jpg");
            jsonArray.put("http://www.pngmart.com/files/1/Cherry-Fruit-PNG-File.png");
            jsonArray.put("http://3.bp.blogspot.com/-cv67N_zmvsQ/UUMZTf2Gf8I/AAAAAAAAKXw/xpxdnfloG0w/s1600/Cherry+benefits.jpg");
            jsonArray.put("https://3.bp.blogspot.com/-mzRAeOMvow8/V0bbQ60nGkI/AAAAAAAAHy0/caaAAy-TrmYEhjnj4Sx61oZg7Oge8lTIwCLcB/s1600/Cherry1.jpg");
            jsonArray.put("http://www.thepacker.com/sites/produce/files/field/image/cherry_1.jpg");
            jsonObject.put("data", jsonArray);
            output = jsonObject.toString();
            Data data_ob = Data.getInstance();
            data_ob.setData(output);
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            js.put("speech", "cherry are displayed");
            js.put("displayText", "cherry are displayed");
            js.put("source", "image database");
            response = js.toString();
        }
        else if (parameters.get("fruits").toString().equals("banana")){
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put("http://www.fruit-full.com/images/BANANA_PLATANO.jpg");
            jsonArray.put("https://cdn0.iconfinder.com/data/icons/fruits/512/Banana.png");
            jsonArray.put("http://www.freshfruitportal.com/assets/uploads/2013/07/banana_ffp2.jpg");
            jsonArray.put("http://emagrecer.eco.br/wp-content/uploads/2016/11/doce-torta-bala-brownie-cacho-potassio-energia.jpg");
            jsonArray.put("https://s-media-cache-ak0.pinimg.com/originals/d2/a4/dd/d2a4dd499cc4f7069f7727c8fbf25e47.jpg");
            jsonArray.put("https://ae01.alicdn.com/kf/HTB1OW0IJpXXXXasXVXXq6xXFXXX4/100pcs-font-b-FRUIT-b-font-font-b-banana-b-font-seeds-health-font-b-fruit.jpg");
            jsonObject.put("data", jsonArray);
            output = jsonObject.toString();
            Data data_ob = Data.getInstance();
            data_ob.setData(output);
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            js.put("speech", "banana are displayed");
            js.put("displayText", "banana are displayed");
            js.put("source", "image database");
            response = js.toString();
        }
        else if (parameters.get("null").toString().equals("clear")){
            Data data_ob = Data.getInstance();
            JSONObject js1 = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(" ");
            js1.put("data", jsonArray);
            data_ob.setData(js1.toString());
            data_ob.setFlag(true);
            JSONObject js = new JSONObject();
            js.put("speech", "screen is cleared");
            js.put("displayText", "screen is cleared");
            js.put("source", "image database");
            response = js.toString();
        }
        resp.setHeader("Content-type", "application/json");
        resp.getWriter().write(response);
    }
}
