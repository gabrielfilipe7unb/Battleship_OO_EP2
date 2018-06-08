# READ ME 

Tal projeto consiste no desenvolvimento de um jogo de "Batalha Naval" adaptado para 1 player, utilizando os conceitos de Orientação a Objetos.

## 1. Tela inicial

  1.1 - Nome do jogador (PLAYER NAME)
  1.2 - Botão "Rank"
  1.3 - Botão "Fechar Jogo"
  1.4 - Botão "Iniciar Jogo"
  
    1.2.1 - Ao clicar no botão "Rank" o jogador será direcionado à uma tela de ranqueamento que é computado todas as pontuações dos players que jogaram ANTES do jogo ser finalizado. Caso o jogo seja finalizado o Rank é ZERADO para que não haja acumulo de dados com o tempo.
    1.3.1 - Ao clicar no botão "Fechar Jogo" o jogo finalizará.
    1.4.1 - Ao clicar no botão "Iniciar Jogo", o usuário será direcionado para uma tela de busca dos arquivos do mapa. Quatro mapas foram disponibilizado aos jogadores no diretório /EP2_OO/src/maps. Caso o usuário não queira jogar com nenhum dos mapas diponibilizados ele pode apertar no botão "Cancelar" e será direcionado à um mapa padrão de tamanho 10x10.
    
## 2. Tabuleiro
  
  2.1 - Botão "Novo Jogo"
  2.2 - Botão "Voltar"
  
  2.3 - Tiros Especiais
  
    2.3.1 - Botão "Atacar coluna!"
    2.3.2 - Botão "Atacar linha!"
    2.3.3 - Botão "Atacar 2x2!"
    2.3.4 - Botão "Espionar 2x2!"
    
  2.4 - Botão "Atacar Normal!"

  
    2.1.1 - Ao clicar em "Novo Jogo" o jogador é direcionado para tela de escolha de mapas. Novamente, o usuário será direcionado para uma tela de busca dos arquivos do mapa e, caso o usuário não queira jogar com nenhum dos mapas diponibilizados, ele pode apertar no botão "Cancelar" e será direcionado à um mapa padrão de tamanho 10x10.
    2.2.1 - Ao clicar em "Voltar" o jogador é redirecionado à "Tela Inicial".
    2.3.1.1 - Ao clicar em "Atacar coluna!" o jogador ativará um ataque especial em que possibilitará que ele ataque uma coluna por completo com apenas um tiro. 
    2.3.2.1 - Ao clicar em "Atacar linha!" o jogador ativará um ataque especial em que possibilitará que ele ataque uma linha por completo com apenas um tiro. 
    2.3.3.1 - Ao clicar em "Atacar 2x2!" o jogador ativará um ataque especial em que possibilitará que ele ataque uma área 2x2 com apenas um tiro. O elemento que for clicado será o elemento [1][1] de uma matriz [2][2].
    2.3.4.1 - Ao clicar em "Espionar 2x2!" o jogador ativará um ataque especial em que possibilitará que ele visualize se em uma área 2x2 há alguma embarcação. O elemento que for clicado será o elemento [1][1] de uma matriz [2][2].
    2.4.1 - Ao clicar em "Atacar Normal!" o jogador voltará à opção de ataque normal.
    
    Observação: todo jogador tem direito à somente 3 "Tiros Especiais".
    
## 3. Rank
  
  3.1 - Botão "Voltar"
  
    3.1.1 - Ao clicar em "Voltar" o jogador é redirecionado à "Tela Inicial".
    
## OBSERVAÇÕES
 
    Deve-se adicionar o JUnit4 para a execução dos testes.
  
