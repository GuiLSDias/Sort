package javassortaula;

public class Search {

    private long contaComparacoes;

    public long getContaComparacoes() {
        return contaComparacoes;
    }

    public int linearSearch(Integer[]v, Integer x) {
        this.contaComparacoes = 0;
        for (int i = 0; i < v.length; i++) {
            this.contaComparacoes ++;
            if (x.equals(v[i]))
                return i;
            }
            return -1;
    }

    public int binarySearch(Integer[]v, Integer x) {
        int inicio = 0;
        int fim = v.length - 1;
        this.contaComparacoes = 0;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            this.contaComparacoes++;
            if(x.equals(v[meio]))
                return meio;
            else if (x < v[meio])
                fim = meio - 1;
            else
                inicio = meio + 1;
        }
        return -1;
    }
}
