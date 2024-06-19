package exemplos;

// Interface Strategy
interface SortingStrategy {
    void sort(int[] numbers);
}

// Implementação concreta de uma estratégia
class BubbleSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        System.out.println("Bubble Sort applied");
    }
}

// Implementação concreta de outra estratégia
class QuickSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
        System.out.println("Quick Sort applied");
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

// Classe Contexto
class Sorter {
    private SortingStrategy strategy;

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] numbers) {
        strategy.sort(numbers);
    }
}

// Uso do padrão Strategy
public class Strategy {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 4, 2};

        Sorter sorter = new Sorter();

        sorter.setStrategy(new BubbleSortStrategy());
        sorter.sort(numbers);

        sorter.setStrategy(new QuickSortStrategy());
        sorter.sort(numbers);
    }
}
