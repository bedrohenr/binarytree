# Árvore Binária

Código fonte do rabalho de árvore binária para obtenção de nota na disciplina Técnicas de Programação Avançadas ministrada pelo professor Victorio Albani de Carvalho.

## Estrutura de arquivos do projeto

```
binarytree/
├── src/
│   ├── app/
│   │   ├── Aluno.java                  
│   │   ├── AppRelatorioArvoreBinaria.java  
│   │   ├── AppRelatorioAVL.java             
│   │   ├── ComparadorAlunoPorMatricula.java
│   │   ├── ComparadorAlunoPorNome.java      
│   │   └── GeradorDeArvores.java          
│   │
│   ├── appCaixaMercado/            
│   │   ├── Caixa.java                 
│   │   ├── ComparadorProdutoPorCodigo.java
│   │   ├── ComparadorProdutoPorNome.java
│   │   └── Produto.java        
│   │
│   └── lib/                         
│       ├── ArvoreBinaria.java            
│       ├── ArvoreBinariaAVL.java     
│       ├── IArvoreBinaria.java      
│       ├── MainTesteAVL.java      
│       └── No.java              
│
└── Main.java                    
```

## Execuções

### Main.java

O método Main.java, na raiz, consiste no app de caixa de mercado e executando-o você pode adicionar produtos, remover, pesquisar, por código ou nome,  ou listar todos produtos.

### MainTesteAVL.java

Executa e adiciona produtos a uma árvore binária e uma árvore binária AVL, e podemos ver diferenças pelo output da altura de ambas e mostrando elementos em nível.

### AppRelatorioArvoreBinaria.java

Instancia e adiciona diversos elementos às árvores, para o relatório na especificação.

### AppRelatorioAVL.java

Instancia árvores binárias normais e árvores binárias AVL para destacar diferenças em uso do balanceamento.
