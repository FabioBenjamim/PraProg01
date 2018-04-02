USE chatbot;

INSERT INTO Resposta (id_Resposta, resposta_Resposta) VALUES (1,'Carlos Drummond de Andrade');
INSERT INTO Palavra_Chave (id_Palavra_Chave, palavra_Palavra) VALUES (1,'Carlos');
INSERT INTO Palavra_Chave (id_Palavra_Chave, palavra_Palavra) VALUES (1,'completo');
INSERT INTO Pergunta (id_Pergunta, pergunta_Pergunta) VALUES (3,'Qual é o nome completo de Carlos?');

SELECT Pergunta.pergunta_Pergunta				AS 'Pergunta',
	   Resposta.resposta_Resposta				AS 'Resposta',
	   Palavra_Chave.palavra_Palavra			AS 'Palavra Chave'      
		  FROM Resposta INNER JOIN Palavra_Chave INNER JOIN Pergunta
          WHERE pergunta.pergunta_Pergunta = palavra_chave.palavra_Palavra AND palavra_chave.palavra_Palavra = resposta.resposta_Resposta;
          
SELECT resposta_Resposta as 'Resposta' FROM Resposta join palavra_chave WHERE resposta_Resposta LIKE palavra_chave.palavra_Palavras;

SELECT resposta.resposta_Resposta 
FROM Resposta INNER JOIN Pergunta 
ON (Resposta.resposta_Resposta = pergunta.pergunta_Pergunta);

SELECT Pergunta.pergunta_Pergunta, Resposta.resposta_Resposta, Palavra_Chave.palavra_Palavra 
		FROM resposta INNER JOIN pergunta 
		ON pergunta.pergunta_Pergunta = palavra_chave.palavra_Palavra
		where Resposta.resposta_Resposta =  palavra_chave.palavra_Palavra;