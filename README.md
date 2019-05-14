# Lista de comando para iniciar um repositorio
1. Crie o repositorio no site!
2. Crie uma pasta com o mesmo nome do repositorio!
	1. Dentro da pasta, de os seguintes comandos:
		* git init
		* git remote add origin https://github.com/NOMEdeUSUARIO/NOMEdoREPOSITORIO
		* echo "TESTE" >> README.md
		* git status
		* git add .
		* git commit -m "First Commit"
		* git push origin master

# Comandos mais usuais

```bash
$ git status
```
*Lista os arquivos que foram modificados/criados desde de o ultimo commit, em vermelho estão os arquivos
que não entrarão no próximo commit, e em verde estão os commits que serão entrados no proximo commit*
___
```bash
$ git add NomeArquivo
```
*Caso você deseja adicionar um arquivo que estava em vermelho no proximo commit, e torna-lo verde você usa
esse comando, se você fizer um "git add ." você adiciona a lista inteira*
___
```bash
$ git commit -m "NomeDoCommit"
```
*Depois de você listar todos os arquivos (git add ) que você quer que entre no commit, você utiliza esse comando
para criar o commit*
___
```bash
$ git checkout NomeArquivo
```
*Caso você deseja voltar um arquivo para o ultimo commit, utilize este comando, se utilizar "git checkout .",
todos os arquivos da lista voltarão para o ultimo commit*
___
```bash
$ git pull NomeRepositorio(origin) NomeDaBranch(master)
```
*Baixa todos os commits da nuvem.*
___
```bash
$ git push NomeRepositorio(origin) NomeDaBranch(master)
```
*Envia todos os commits locais para a nuvem.*
___
```bash	
$ git clone https://github.com/NOMEdeUSUARIO/NOMEdoREPOSITORIO
```
*Clona o repositorio da nuvem.*
___
