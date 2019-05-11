Lista de comando para iniciar um repositorio
1 - Crie o repositorio no site!
2 - Crie uma pasta com o mesmo nome do repositorio!
	2.1 - Dentro da pasta, de os seguintes comandos:
		* git init
		* git remote add origin https://github.com/NOMEdeUSUARIO/NOMEdoREPOSITORIO
		* echo "TESTE" >> README.md
		* git status
		* git add .
		* git commit -m "First Commit"
		* git push origin master

Comandos mais usuais
1 - git status
	Lista os arquivos que foram modificados/criados desde de o ultimo commit, em vermelho est�o os arquivos
que n�o entrar�o no pr�ximo commit, e em verde est�o os commits que ser�o entrados no proximo commit
2 - git add NomeArquivo
	Caso voc� deseja adicionar um arquivo que estava em vermelho no proximo commit, e torna-lo verde voc� usa
esse comando, se voc� fizer um "git add ." voc� adiciona a lista inteira
3 - git commit -m "NomeDoCommit"
	Depois de voc� listar todos os arquivos (git add ) que voc� quer que entre no commit, voc� utiliza esse comando
para criar o commit
4 -  git checkout NomeArquivo
	Caso voc� deseja voltar um arquivo para o ultimo commit, utilize este comando, se utilizar "git checkout .",
todos os arquivos da lista voltar�o para o ultimo commit
5 - git pull NomeRepositorio(origin) NomeDaBranch(master)
	Baixa todos os commits da nuvem.
6 - git push NomeRepositorio(origin) NomeDaBranch(master)
	Envia todos os commits locais para a nuvem.

