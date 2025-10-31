package com.algo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;

import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.WekaPackageManager;
import weka.core.converters.ArffLoader;

import com.connection.Dbconn;

public class ClassifierANN {
	
	public int Execute(String train, String test) throws FileNotFoundException, IOException, Exception {
       	int rval = 0;
     //   double acc=0.0;
        boolean T = false;
        try {
        	 Connection conn = (Connection) Dbconn.conn();
            rval = 1;
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

			MultilayerPerceptron ann = new MultilayerPerceptron();

//Load weka path
			WekaPackageManager.loadPackages(false, true, false);
//			 ann.setLearningRate(0.1);
//             ann.setMomentum(0.2);
//             ann.setTrainingTime(25);
//             ann.setHiddenLayers("3");
			ann.setOptions(Utils.splitOptions("-L 0.1 -M 0.2 -N 40 -V 0 -S 0 -E 20 -H 4"));
            
			                                           
			 ann.buildClassifier(instTest);
			T = false;
			Evaluation evaluation = new Evaluation(instTest);
			evaluation.crossValidateModel(ann, instTest, 10, new Random(1));
			System.out.println(evaluation.toSummaryString());

			double correctClass = 0;
			double records = 0;
			int i = 1;
			//attributes.remove();
			for (i = 1; i < instTest.numInstances(); i++) {
			    records++;
			    double pred = 0, pred1 = 0, pred2 = 0, pred3 = 0, pred4 = 0, pred5 = 0, pred6 = 0, pred7 = 0;
			    int classArray[] = new int[5];

			    pred = ann.classifyInstance(instTest.instance(i));
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
			    if (actualClass.equalsIgnoreCase(predictedClass)) {
			        correctlyPredicted[maxClass]++;
			        correctClass++;
			    }
			}
                
			double acc = (evaluation.correct() / (records) * 100);
			System.out.println("ANN Accuracy : " + acc);
			System.out.println("precision : " + evaluation.precision(0));
			System.out.println("recall : " + evaluation.recall(0));
			System.out.println("fMeasure : " + evaluation.fMeasure(0));
			 Statement st1 = conn.createStatement();
			 st1.executeUpdate("update accuracydata set Accuracy_data='"+acc+"',Precision_data='"+evaluation.precision(0)+"', Recall_data='"+evaluation.recall(0)+"',F_measure_data='"+evaluation.fMeasure(0)+"' where Algorithm_Name='ANNClass'");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rval;
    }
}
