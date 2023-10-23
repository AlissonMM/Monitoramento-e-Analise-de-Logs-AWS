import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidadeLogs = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Map<String, Long> eventosPorServico = new HashMap<>();
        for (int i = 0; i < quantidadeLogs; i++) {
            String[] parts = scanner.nextLine().split(",");
            String servico = parts[1];
            //Utilize o mapa para registrar/incrementar o serviço em questão.
            if (eventosPorServico.containsKey(servico)) {
                // Se estiver no mapa
                // aumenta mais um value
                eventosPorServico.compute(servico, (key, value) -> value + 1);
            } else {
                // Se não estiver no mapa
                // apenas adiciona com um value
                eventosPorServico.put(servico, 1L);
            }
        }


            // Identifique no mapa os serviços com maior e menor quantidade de logs.
            //      Dica: Utilize Java Streams para tornar essa tarefa mais simples.

            //Cria uma lista com os entry sets do map e da um 'sort' comparando os valores, os transformando em lista
            List<Map.Entry<String, Long>> listaOrdenada = eventosPorServico.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .toList();

            //pega as chaves de entrys de maior e menor value
            String menorEvento = listaOrdenada.get(0).getKey();
            String maiorEvento = listaOrdenada.get(listaOrdenada.size() - 1).getKey();

            //Imprima a saída no padrão definido no enunciado deste desafio.

            System.out.println("Eventos por servico:");
            //um for para apresentar todos dos dados do map com a formatação pedida
            for (var p : eventosPorServico.entrySet()){
                System.out.println(p.getKey() + ":" + p.getValue());
            }
            System.out.println("Maior:" + maiorEvento);
            System.out.println("Menor:" + menorEvento);
        }
    }
