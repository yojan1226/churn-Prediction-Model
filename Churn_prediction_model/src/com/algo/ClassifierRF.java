package com.algo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;

import com.connection.Dbconn;

import weka.classifiers.AbstractClassifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ArffLoader;
import weka.core.WekaPackageManager;

public class ClassifierRF {

    public int Executes(String train, String test) throws FileNotFoundException, IOException, Exception {
        // TODO code application logic hereInstances trainset=new Instances(new BufferedReader(new FileReader("C:/project/traindataset.arff")));

        int rval = 0;
        boolean T = false;
        try {
            Connection conn = (Connection) Dbconn.conn();
            rval = 1;
            if (true) {
                int correctlyPredicted[] = new int[5];
                ArffLoader al = new ArffLoader();
                al.setFile(new File(train));
                Instances inst = al.getDataSet();
                inst.setClassIndex(inst.numAttributes() - 1);

                ArffLoader alTest = new ArffLoader();
                alTest.setFile(new File(test));
                Instances instTest = alTest.getDataSet();
                instTest.setClassIndex(instTest.numAttributes() - 1);
                //instTest.setClassMissing();

                RandomForest RF = null;

//Load weka path
                WekaPackageManager.loadPackages(false, true, false);
                AbstractClassifier classifier = (AbstractClassifier) Class.forName(
                        "weka.classifiers.functions.LibSVM").newInstance();

                RF = new RandomForest();
                RF.setBatchSize("100");
				RF.setOptions(Utils.splitOptions("-I 2 -K 1 -S 1 -num-slots 1"));
              
//                
//               
//-I <number of trees>   Number of trees to build.
// -K <number of features>   Number of features to consider (<1=int(logM+1)).
// -S   Seed for random number generator.  (default 1)
// -depth <num>   The maximum depth of the trees, 0 for unlimited.  (default 0)
// -D   If set, classifier is run in debug mode and   may output additional info to the console
                // RF.setOptions(options);
                RF.buildClassifier(instTest);
                T = false;
                Evaluation evaluation = new Evaluation(instTest);
                evaluation.evaluateModel(RF, instTest);
                System.out.println(evaluation.toSummaryString());

                double correctClass = 0;
                double records = 0;
                int i = 1;
                //attributes.remove();
                for (i = 0; i < instTest.numInstances(); i++) {
                    records++;
                    double pred = 0, pred1 = 0, pred2 = 0, pred3 = 0, pred4 = 0, pred5 = 0, pred6 = 0, pred7 = 0;
                    int classArray[] = new int[5];

//                    pred = RF.classifyInstance(instTest.instance(i));
                    classArray[(int) pred]++;

                    int maxClass = 0;
                    for (int k = 1; k < classArray.length; k++) {
                        if (classArray[k] > classArray[maxClass]) {
                            maxClass = k;
                        }
                    }

                    String actualClass = instTest.classAttribute().value((int) instTest.instance(i).classValue());
                    String predictedClass = instTest.classAttribute().value((int) maxClass);
                    System.out.println("Actual Class is :" + actualClass);
                    System.out.println("Predicted Class is :" + predictedClass);
                    Statement st = conn.createStatement();
//                    st.executeUpdate("update testdata set RFClass='" + predictedClass + "' where id ='" + (records) + "'");
                    if (actualClass.equalsIgnoreCase(predictedClass)) {
                        correctlyPredicted[maxClass]++;
                        correctClass++;
                    }
                }
//                printMeasures(evaluation, T);
//                System.out.println("No of records : " + records);
//                System.out.println("Correctly classified : " + correctClass);
//                System.out.println("Incorrectly classified : " + (records - correctClass));
//                System.out.println("Accuracy : " + (correctClass / (records) * 100));
//                Dbconn.RFclass=(correctClass / (records) * 100);
                
               double acc = (evaluation.correct() / (records) * 100);
                System.out.println("RF Accuracy : " + acc);
                System.out.println("precision : " + evaluation.precision(0));
                System.out.println("recall : " + evaluation.recall(0));
                System.out.println("fMeasure : " + evaluation.fMeasure(0));
                Statement st1 = conn.createStatement();
                st1.executeUpdate("update accuracydata set Accuracy_data='"+acc+"',Precision_data='"+evaluation.precision(0)+"', Recall_data='"+evaluation.recall(0)+"',F_measure_data='"+evaluation.fMeasure(0)+"' where Algorithm_Name='RFClass'");
            } else {
                rval = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rval;
    }

}
