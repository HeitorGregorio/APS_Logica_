package main_package;

import java.util.Scanner;


/*APS LÛgica Anhembi Morumbi
    Problema: Dilema do Prisioneiro
        Integrantes: Heitor GregÛrio dos Santos  RA: 20649736
                     Carolinne da Silva Lima     RA: 20840066
                     JosÈ Bezerra Bastos Neto    RA: 21218792
                     Camila Pires Levi           RA: 20895075
*/
public class APS_Logica_ {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int i = 0;//Quantidade de vezes jogada
        int QuantidadeErros = 0;//Quantidade de erros
        int Trair_x_Trair = 0;// trair x trair
        int Cooperar_x_Cooperar = 0;// cooperar x cooperar
        int Trair_x_cooperar = 0;// trair x cooperar
        int EscolhaEstrategia;//variavel de escolha de estrategia
        int RespostaUsuario;//Variavel de resposta usuario
        int RespostaComparsa;//Variavel de resposta da maquina
        boolean LoopJogo = true;//variavel que controla o loop do jogo inteiro
        String Estrategia = "";//variavel para decidir se troca de estrategia
        boolean erro = false;//variavel que controla o repeti√ßao, caso haja algum erro

        System.out.println(" ");
        System.out.println("\t\t\t\t---------------- JOGO INICIADO !! -----------------");
        System.out.println(" ");

        //Inicio do jogo
        System.out.println("OBS: SOMENTE N√öMERO!!!");
        System.out.println(" ");

        while (LoopJogo) {//loop que controla se o jogo continua ou fecha

            do {
                System.out.println("ESCOLHA UMA ESTRAT√âGIA: ");

                //Escolha estrat√©gia
                System.out.println("0 = N√O ITERADO,"
                        + "\t 1 = OLHO POR OLHO,"
                        + "\t 2 = OLHO POR DOIS OLHOS,"
                        + "\t 3 = PROVADOR ING NUO,"
                        + "\t 4 = RETALIADOR PERMANENTE,"
                        + "\t 5 = SAIR E FECHAR O JOGO");

                EscolhaEstrategia = ler.nextInt();//ler estrategia do jogador

                if (EscolhaEstrategia != 0 && EscolhaEstrategia != 1 && EscolhaEstrategia != 2 && EscolhaEstrategia != 3 && EscolhaEstrategia != 4 && EscolhaEstrategia != 5) {
                    erro = true;
                    System.out.println("\n\nOP«√O ERRADA, TENTE NOVAMENTE\n\n");
                } else {
                    erro = false;
                }

            } while (erro);

            switch (EscolhaEstrategia) {
                case 0:

                    boolean case0 = true;

                    System.out.println("N√O ITERADO\n");//estrategia

                    while (case0) {
                        //come√ßar escrever o que fazer
                        System.out.println("\n\n\n1 = Trair ou 0 = Cooperar: \n");
                        RespostaUsuario = ler.nextInt();
                        RespostaComparsa = (int) (Math.random() * 2);

                        if (RespostaUsuario == 0 || RespostaUsuario == 1) {//teste para ver se digitou corretamente

                            int retorno = mensagens(RespostaUsuario, RespostaComparsa, Cooperar_x_Cooperar, Trair_x_Trair, Trair_x_cooperar);
                            switch (retorno) {
                                case 1:
                                    Cooperar_x_Cooperar++;
                                    break;
                                case 2:
                                    Trair_x_Trair++;
                                    break;
                                default:
                                    Trair_x_cooperar++;
                            }

                            System.out.println("------------------------------");

                            do {
                                System.out.println("\nDeseja continuar com a estrategia? (s/n)");
                                Estrategia = ler.next();
                                if (Estrategia.equals("S") || Estrategia.equals("s")) {
                                    erro = false;
                                    //continua a estrategia
                                } else if (Estrategia.equals("N") || Estrategia.equals("n")) {
                                    System.out.println("trocar estrategia");
                                    case0 = false;//trocar estrategia
                                    erro = false;
                                } else {
                                    System.out.println("Digitou algo errado. Tente novamente!");
                                    QuantidadeErros++;
                                    erro = true;
                                }
                            } while (erro);

                            //else do teste para ver se digitou corretamente
                        } else {
                            System.out.println("Digitou algo errado. Tente novamente!");
                            QuantidadeErros++;
                            i--;//retira a jogada caso erro
                        }
                        i++;//Conta quantas rodadas
                    } //fim do case0
                    break;

                //
                //
                //
                case 1:

                    boolean case1 = true;

                    System.out.println("OLHO POR OLHO\n");//estrategia

                    RespostaComparsa = (int) (Math.random() * 2);

                    while (case1) {
                        //come√ßar escrever o que fazer
                        System.out.println("\n\n\n1 = Trair ou 0 = Cooperar: \n");
                        RespostaUsuario = ler.nextInt();

                        if (RespostaUsuario == 0 || RespostaUsuario == 1) {//teste para ver se digitou corretamente

                            int retorno = mensagens(RespostaUsuario, RespostaComparsa, Cooperar_x_Cooperar, Trair_x_Trair, Trair_x_cooperar);
                            switch (retorno) {
                                case 1:
                                    Cooperar_x_Cooperar++;
                                    break;
                                case 2:
                                    Trair_x_Trair++;
                                    break;
                                default:
                                    Trair_x_cooperar++;
                            }

                            System.out.println("------------------------------");

                            RespostaComparsa = RespostaUsuario;

                            do {
                                System.out.println("\nDeseja continuar com a estratÈgia? (s/n)");
                                Estrategia = ler.next();
                                if (Estrategia.equals("S") || Estrategia.equals("s")) {
                                    erro = false;
                                    //continua a estrategia
                                } else if (Estrategia.equals("N") || Estrategia.equals("n")) {
                                    System.out.println("trocar estrategia");
                                    case1 = false;//trocar estrategia
                                    erro = false;
                                } else {
                                    System.out.println("Digitou algo errado. Tente novamente!");
                                    QuantidadeErros++;
                                    erro = true;
                                }
                            } while (erro);

                            //else do teste para ver se digitou corretamente
                        } else {
                            System.out.println("Digitou algo errado. Tente novamente!");
                            QuantidadeErros++;
                            i--;//retira a jogada caso erro
                        }
                        i++;//Conta quantas rodadas
                    } //fim do case1
                    break;

                //come√ßar escrever o que fazer
                //System.out.println("1 = Trair ou 0 = Cooperar: ");
                //res = ler.nextInt();
                case 2:
                    System.out.println("OLHO POR DOIS OLHOS\n");//estrategia

                    boolean case2 = true;
                    int repetida = 2; //quantidade de vezes que for igual a res
                    int vez = 0;

                    while (case2) {
                        //come√ßar escrever o que fazer
                        System.out.println("\n\n\n1 = Trair ou 0 = Cooperar: ");
                        RespostaUsuario = ler.nextInt();//res = ler.nextInt();

                        if (RespostaUsuario == 1 || RespostaUsuario == 0) {//teste para ver se digitou corretamente

                            //se true, significa que a resposta foi repetida 2 vezes seguidas
                            if (vez > 0) {
                                RespostaComparsa = repetida;
                            } else {//se nao repetida, escolha da maquina √© aleatorizada
                                RespostaComparsa = (int) (Math.random() * 2);
                            }

                            //teste para testar se a resposta foi repetida
                            if (RespostaUsuario == repetida) {
                                vez++;//se a resposta for igual a jogada anterior, condi√ß√£o ser√° true
                            } else {
                                vez = 0;//sen√£o vez continua 0 ou √© volta para 0
                            }

                            int retorno = mensagens(RespostaUsuario, RespostaComparsa, Cooperar_x_Cooperar, Trair_x_Trair, Trair_x_cooperar);
                            switch (retorno) {
                                case 1:
                                    Cooperar_x_Cooperar++;
                                    break;
                                case 2:
                                    Trair_x_Trair++;
                                    break;
                                default:
                                    Trair_x_cooperar++;
                            }

                            System.out.println("------------------------------");

                            repetida = RespostaUsuario;

                            do {
                                System.out.println("\nDeseja continuar com a estratÈgia? (s/n)");
                                Estrategia = ler.next();
                                if (Estrategia.equals("S") || Estrategia.equals("s")) {
                                    erro = false;
                                    //continua a estrategia
                                } else if (Estrategia.equals("N") || Estrategia.equals("n")) {
                                    System.out.println("trocar estrategia");
                                    case2 = false;//trocar estrategia
                                    erro = false;
                                } else {
                                    System.out.println("Digitou algo errado. Tente novamente!");
                                    QuantidadeErros++;
                                    erro = true;
                                }
                            } while (erro);

                            //else do teste para ver se digitou corretamente
                        } else {
                            System.out.println("Digitou algo errado. Tente novamente!");
                            QuantidadeErros++;
                            i--;//retira a jogada caso erro
                        }
                        i++;//conta uma jogada  
                    }      //fim do case 2
                    break;

                case 3:
                    System.out.println("PROVADOR ING NUO\n");//estrategia

                    boolean case3 = true;

                    RespostaComparsa = (int) (Math.random() * 2);

                    while (case3) {
                        //come√ßar escrever o que fazer
                        System.out.println("\n\n\n1 = Trair ou 0 = Cooperar: \n");
                        RespostaUsuario = ler.nextInt();

                        if (Math.random() * 100 < 69) {//70% de chance de continuar olho por olho (copiar a escolha)
                            RespostaComparsa = RespostaUsuario;
                        } else if (Math.random() * 100 > 70) {//30% de chance de trair na escolha
                            RespostaComparsa = 1;
                        }

                        if (RespostaUsuario == 0 || RespostaUsuario == 1) {//teste para ver se digitou corretamente

                            int retorno = mensagens(RespostaUsuario, RespostaComparsa, Cooperar_x_Cooperar, Trair_x_Trair, Trair_x_cooperar);
                            switch (retorno) {
                                case 1:
                                    Cooperar_x_Cooperar++;
                                    break;
                                case 2:
                                    Trair_x_Trair++;
                                    break;
                                default:
                                    Trair_x_cooperar++;
                            }

                            System.out.println("------------------------------");

                            do {
                                System.out.println("\n\nDeseja continuar com a estratÈgia? (s/n)");
                                Estrategia = ler.next();
                                if (Estrategia.equals("S") || Estrategia.equals("s")) {
                                    erro = false;
                                    //continua a estrategia
                                } else if (Estrategia.equals("N") || Estrategia.equals("n")) {
                                    System.out.println("trocar estrategia");
                                    case3 = false;//trocar estrategia
                                    erro = false;
                                } else {
                                    System.out.println("Digitou algo errado. Tente novamente!");
                                    QuantidadeErros++;
                                    erro = true;
                                }
                            } while (erro);

                            //else do teste para ver se digitou corretamente
                        } else {
                            System.out.println("Digitou algo errado. Tente novamente!");
                            QuantidadeErros++;
                            i--;//retira a jogada caso erro
                        }
                        i++;//Conta quantas rodadas
                    } //fim do case3
                    break;

                case 4:
                    System.out.println("RETALIADOR PERMANENTE");//estrategia

                    boolean case4 = true;

                    RespostaComparsa = 0;

                    while (case4) {
                        //come√ßar escrever o que fazer
                        System.out.println("\n\n\n1 = Trair ou 0 = Cooperar: \n");
                        RespostaUsuario = ler.nextInt();

                        if (RespostaUsuario == 0 || RespostaUsuario == 1) {//teste para ver se digitou corretamente

                            int retorno = mensagens(RespostaUsuario, RespostaComparsa, Cooperar_x_Cooperar, Trair_x_Trair, Trair_x_cooperar);
                            switch (retorno) {
                                case 1:
                                    Cooperar_x_Cooperar++;
                                    break;
                                case 2:
                                    Trair_x_Trair++;
                                    break;
                                default:
                                    Trair_x_cooperar++;
                            }

                            System.out.println("------------------------------");

                            if (RespostaUsuario == 1) {
                                RespostaComparsa = 1;
                            }

                            do {
                                System.out.println("\n\nDeseja continuar com a estratÈgia? (s/n)");
                                Estrategia = ler.next();
                                if (Estrategia.equals("S") || Estrategia.equals("s")) {
                                    erro = false;
                                    //continua a estrategia
                                } else if (Estrategia.equals("N") || Estrategia.equals("n")) {
                                    case4 = false;//trocar estrategia
                                    erro = false;
                                } else {
                                    System.out.println("Digitou algo errado. Tente novamente!");
                                    QuantidadeErros++;
                                    erro = true;
                                }
                            } while (erro);

                            //else do teste para saber se digitou corretamente
                        } else {
                            System.out.println("Digitou algo errado. Tente novamente!");
                            QuantidadeErros++;
                            i--;//retira a jogada caso erro
                        }
                        i++;//Conta quantas rodadas
                    } //fim do case4
                    break;

                case 5:
                    System.out.println("\n\n");
                    System.out.println("Foram jogadas " + i + " rodadas");
                    System.out.println("Digitou algo errado: " + QuantidadeErros + " vezes");
                    System.out.println("\n");
                    System.out.println(Trair_x_Trair * 100 / i + "% das vezes ocorreu TRAIR X TRAIR");
                    System.out.println(Cooperar_x_Cooperar * 100 / i + "% das vezes ocorreu COOPERAR X COOPERAR");
                    System.out.println(Trair_x_cooperar * 100 / i + "% das vezes ocorreu TRAIR X COOPERAR");
                    /*
                            teste e compara√ßao de porcentagem
                     */
                    System.exit(0);
                    break;//fim do case5

                default:// CASO DIGITE ALGO ERRADO ELE SAI
                    System.out.println("Digitou algo errado. Tente novamente!");
                    QuantidadeErros++;//Conta quantos erros
                    break;
            }

            do {
                System.out.println("\n\nDeseja escolher nova estratÈgia? \ns = SIM\nn = SAIR E FECHAR");
                Estrategia = ler.next();
                if (Estrategia.equals("S") || Estrategia.equals("s")) {
                    erro = false;
                    //continua a estrategia
                } else if (Estrategia.equals("N") || Estrategia.equals("n")) {
                    erro = false;
                    LoopJogo = false;
                } else {
                    System.out.println("\n\nDigitou algo errado. Tente novamente!");
                    QuantidadeErros++;
                    erro = true;
                }
            } while (erro);

        }//while(jogo)
        System.out.println("\n\n");
        System.out.println("Jogador, ");
        System.out.println("Foram jogadas " + i + " rodadas");
        System.out.println("Digitou algo errado: " + QuantidadeErros + " vezes");
        System.out.println("\n");
        System.out.println(Trair_x_Trair * 100 / i + "% das vezes ocorreu TRAIR X TRAIR");
        System.out.println(Cooperar_x_Cooperar * 100 / i + "% das vezes ocorreu COOPERAR X COOPERAR");
        System.out.println(Trair_x_cooperar * 100 / i + "% das vezes ocorreu TRAIR X COOPERAR");
        /*
                teste e compara√ßao de porcentagem
         */
    }

    public static int mensagens(int res, int comparsa, int cc, int tt, int tc) {
        if (res == 0 && comparsa == 0) {
            //cc++;//cooperar x cooperar
            System.out.println("VOC√ä COOPEROU");
            System.out.println("COMPARSA COOPEROU");
            System.out.println("2 ANOS CADA");
            return 1;

        } else if (res == 1 && comparsa == 1) {
            //tt++;// trair x trair
            System.out.println("VOC√ä TRAIU");
            System.out.println("COMPARSA TRAIU");
            System.out.println("5 ANOS CADA");
            return 2;

        } else if (res == 1 && comparsa == 0) {
            //tc++;// trair x cooperar
            System.out.println("VOC√ä TRAIU");
            System.out.println("COMPARSA COOPEROU");
            System.out.println("COMPARSA PEGOU 10 ANOS");
            System.out.println("VOC√ä ESTA LIVRE");
            return 3;

        } else {
            //tc++;
            System.out.println("VOC√ä COOPEROU");
            System.out.println("COMPARSA TRAIU");
            System.out.println("VOC√ä PEGOU 10 ANOS");
            System.out.println("COMPARSA ESTA LIVRE");
            return 3;
        }
    }

}
        
//fim de classe