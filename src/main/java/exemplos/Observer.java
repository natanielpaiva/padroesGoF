package exemplos;
import java.util.ArrayList;
import java.util.List;

// Interface Observer
interface ObserverInterface {
    void update(String news);
}

// Classe Sujeito (Subject)
class NewsAgency {
    private List<ObserverInterface> observers = new ArrayList<>();
    private String news;

    public void addObserver(ObserverInterface observer) {
        observers.add(observer);
    }

    public void removeObserver(ObserverInterface observer) {
        observers.remove(observer);
    }

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }

    private void notifyObservers() {
        for (ObserverInterface observer : observers) {
            observer.update(news);
        }
    }
}

// Classe Observador
class NewsChannel implements ObserverInterface {
    private String news;

    @Override
    public void update(String news) {
        this.news = news;
        System.out.println("News updated: " + news);
    }
}

// Uso do padrão Observer
public class Observer {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();
        NewsChannel newsChannel = new NewsChannel();

        newsAgency.addObserver(newsChannel);

        newsAgency.setNews("Breaking News!");
    }
}