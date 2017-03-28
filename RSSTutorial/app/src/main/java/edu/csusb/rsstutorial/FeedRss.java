package edu.csusb.rsstutorial;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by JayRyu on 3/28/17.
 */

public class FeedRss extends AsyncTask<Void, Void, Void> {
    Context context;
    ProgressDialog progressDialog;
    String address = "http://www.latimes.com/world/asia/rss2.0.xml";
    URL url;

    public FeedRss(Context context) {
        this.context = context;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.show();
    }
    @Override
    protected Void doInBackground(Void... params) {
        ProcessXml(getData());
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
    }

    private void ProcessXml(Document data) {
        Log.d("ROOT", data.getDocumentElement().getNodeName());
        if (data!=null) {
            Element root = data.getDocumentElement();
            Node channel = root.getChildNodes().item(1);
            NodeList items = channel.getChildNodes();
            for (int i = 0; i < items.getLength(); i++) {
                Node currentchild = items.item(i);
                if (currentchild.getNodeName().equalsIgnoreCase("item")) {
                    NodeList itemchilds = currentchild.getChildNodes();
                    for (int j = 0 ; j < itemchilds.getLength(); j++) {
                        Node current = itemchilds.item(j);
                        Log.d("textcontent", current.getTextContent());
                    }
                }
            }
        }
    }

    private Document getData() {
        try {
            url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            Document xmlDoc = documentBuilder.parse(inputStream);

            return xmlDoc;

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();

            return null;
        }


    }
}
