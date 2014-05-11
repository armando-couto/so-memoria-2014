memoria
=======

Trabalho de Gerenciamento de Memória da NP 2, de sistemas operacionais.

￼Trabalho de Gerenciamento de Memória
1) Objetivo:
Implementar a simulação dos algoritmos de alocação de memória:
1. merge fit (discutido em sala de aula).
2. first fit.
3. quick fit.
4. best fit.
5. worst fit.
6. next fit.
2) Funcionamento:
a) O tamanho total da memória a ser representada é uma entrada da simulação.
b) Uma certa quantidade de processos devem ser criados no início da simulação,
essa quantidade é entrada.
c) Cada processo criado antes da simulação começar deverá conter:
i) O identificador do processo (um número natural não negativo com auto­incremento);
ii) A quantidade de bytes que o processo precisa para executar (aleatório entre 32 e 1024);
iii) O tempo que o processo deverá rodar em segundos (aleatório entre 10s e 30s);
d) O aluno deverá prover um meio de criar processos adicionais durante a execução da simulação.
e) Uma vez que um processo é criado (com os parâmetros definidos a priori), é feita uma requisição de alocação ao gerenciador de memória.
f) O gerenciador de memória (criado pelo aluno) deverá receber essa requisição e respondê­la de acordo com o algoritmo de alocação.
g) As requisições são respondidas devolvendo­se o identificador do bloco de memória que o gerenciador de memória escolheu para aquele processo.
h) Operações que devem ser implementadas no gerenciador de memória:
i) Alocação: busca um bloco livre de acordo com o algoritmo escolhido e retorna para a thread em questão. O bloco deve então fazer parte da lista
de blocos ocupados;
ii) Desalocação: marcar um bloco ocupado como livre e colocá­lo na lista
de blocos livres;
iii) Fusão (no caso do algoritmo merge­fit): fundir blocos livres adjacentes
para formar blocos maiores;
￼3) Implementação:
a) A aplicação deverá prover interface gráfica mostrando claramente o comportamento dos algoritmos (o professor mostrará exemplos de interfaces).
b) A memória deve ser representada por listas encadeadas; de acordo com cada algoritmo de alocação.
c) Cada bloco de memória deverá conter as seguintes informações: i) Identificador do bloco (um número natural);
ii) Tamanho total do bloco (em bytes);
iii) Espaço usado (em bytes);
iv) Referência para o próximo bloco da lista;
OBS. Em caso de dúvidas, procurar o professor durante a aula.
