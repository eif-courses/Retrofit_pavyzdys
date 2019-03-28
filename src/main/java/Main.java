
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        String BASE_URL = "https://omgvamp-hearthstone-v1.p.rapidapi.com";

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CardsAPI cardsAPI = retrofit.create(CardsAPI.class);
        Call<Cards> call = cardsAPI.getCards();

        Call<List<Card>> vienaKorta = cardsAPI.getSingleCard("Ysera");
        vienaKorta.enqueue(new Callback<List<Card>>() {
            @Override
            public void onResponse(Call<List<Card>> call, Response<List<Card>> response) {
                System.out.println("SINGLE CARD"+response.body());
            }

            @Override
            public void onFailure(Call<List<Card>> call, Throwable t) {

            }
        });


        call.enqueue(new Callback<Cards>() {
            @Override
            public void onResponse(Call<Cards> call, Response<Cards> response) {

                System.out.println(response.body());
                Cards cardsList = response.body();

                System.err.println(cardsList.getCardList().get(1));

                //List<Cards> Cardss = response.body(); // Gražina duomenis konvertuotus į įprastus java Objektus


//                JFrame f = new JFrame("Cardss List");
//                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                JList jList = new JList(Cardss.toArray());
//                jList.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
//                JScrollPane scrollPane = new JScrollPane(jList);
//                Container contentPane = f.getContentPane();
//                contentPane.add(scrollPane, BorderLayout.CENTER);
//                f.pack();
//                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                f.setLocationRelativeTo(null);
//                f.setSize(800, 640);
//                f.setVisible(true);



//                jList.addMouseListener(new MouseAdapter() {
//                    @Override
//                    public void mouseClicked(MouseEvent e) {
//                        if (e.getClickCount() == 2) {
//                            JOptionPane.showMessageDialog(null, "You clicked:"+Cardss.get(jList.getSelectedIndex()).getCost());
//                        }
//                    }
//                });

            }
            @Override
            public void onFailure(Call<Cards> call, Throwable t) {
                t.printStackTrace();
                // JOptionPane.showMessageDialog(null, "Error API read Failed. Check the plan settings or Internet connection!");   }
            }
            });
        }
    }
