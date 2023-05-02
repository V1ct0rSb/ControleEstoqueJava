# ControleEstoqueJava

<div>
  <img src="https://user-images.githubusercontent.com/112266976/235698235-5ddedeb8-edff-444f-b6fe-19a457d177de.png" width="600" height="600">
  <img src="https://user-images.githubusercontent.com/112266976/235698241-b7273896-209d-4e2e-8978-4d43a505b299.png" width="600" height="600">
  <img src="https://user-images.githubusercontent.com/112266976/235698277-c2a17ed7-e86d-4970-9f6d-01a54f0b935b.png" width="600" height="600">
  <img src="https://user-images.githubusercontent.com/112266976/235698282-1a484f69-7312-4172-8988-9b5f94079fa1.png" width="600" height="600">
  <img src="https://user-images.githubusercontent.com/112266976/235699179-f07753a2-44a9-4132-8d59-5cf7c4d281bc.png" width="600" height="600">
  <img src="https://user-images.githubusercontent.com/112266976/235698310-203b6733-7d97-421d-9e5d-0b251a9bbeb4.png" width="600" height="600">
  <img src="https://user-images.githubusercontent.com/112266976/235698320-86259d0a-ec31-42bd-b8b7-7125f01eda32.png" width="600" height="600">
  <img src="https://user-images.githubusercontent.com/112266976/235699391-778d0198-3680-4cc5-b7ba-e1cca8cfb52f.png" width="600" height="600">

</div>

<h2>💻 Introdução</h2>

<p>O código é um programa em Java que permite gerenciar um estoque de produtos, incluindo a adição, atualização e remoção de produtos, bem como a geração de relatórios sobre o estoque atual.</p>
<p>Posteriormente, são criados dois ArrayLists, um para armazenar os produtos e outro para armazenar os funcionários. Em seguida, é criado um loop de repetição para apresentar o menu de opções ao usuário e solicitar a escolha de uma das opções disponíveis. </p>
<p>As opções são as seguintes:</p>

<li>Cadastrar funcionário</li>
<li>Cadastrar produto</li>
<li>Atualizar produto</li>
<li>Remover produto</li>
<li>Relatório</li>
<li>Sair</li>

<p>A opção escolhida pelo usuário é capturada pelo Scanner e processada por meio de um switch case.</p>

<p>Na opção 1 cadastra um novo funcionário na lista de funcionários, gerando um ID aleatório e verificando se já não existe um funcionário com o mesmo ID. </p>

<p>Quando o usuário seleciona a opção de cadastrar um novo produto, o programa verifica se há funcionários cadastrados. Se não houver nenhum funcionário cadastrado, ele exibe uma mensagem de erro e volta para o menu principal. Caso contrário, o programa solicita informações sobre o produto a ser cadastrado, incluindo o código, nome, preço, quantidade, data de validade e funcionário responsável. O programa verifica se o código do produto já foi usado e se o preço e a quantidade são maiores que zero. Ele também valida a data de validade, verificando se é uma data válida e se é posterior à data atual.</p>

<p>Outras funções do programa incluem a opção de atualizar ou remover um produto existente e exibir um relatório detalhado do estoque atual. As funções de atualização e remoção solicitam o código do produto que o usuário deseja atualizar ou remover e, em seguida, procuram o produto correspondente no ArrayList de produtos. Se o produto for encontrado, o programa solicita ao usuário as informações atualizadas ou confirmação da remoção do produto. Caso contrário, o programa exibe uma mensagem de erro.</p>


<p>A função de exibição de relatórios percorre o ArrayList de produtos e funcionários, exibindo informações sobre cada produto e funcionário, incluindo o código, nome, preço, quantidade, data de validade e funcionário responsável. O programa também exibe o valor total do estoque atual e a quantidade de produtos e funcionários cadastrados.</p>

<p>A opção 0 finaliza o programa.</p>

<p>Em resumo, o código é um programa em Java que permite gerenciar um estoque de produtos usando classes e objetos e apresenta um menu de opções para o usuário escolher a ação desejada.</p>
