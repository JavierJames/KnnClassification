import java.util.Arrays;


public class App {

	final static int K = 3;
	static int TrainingDataSize =4; 
	static int TestingDataSize =2;
	
	static ArrayBuff [] TestingData2 = new ArrayBuff [2];
	static ArrayBuff [] TrainingData2 = new ArrayBuff [4];
	static Neighbour [] Kneighbours = new Neighbour [K];
	static Neighbour [][] Kneighbours2 = new Neighbour [TrainingData2.length][K];

		   public static void main(String args[]) {
		      // create an array list
/*		      ArrayList al = new ArrayList();
		      System.out.println("Initial size of al: " + al.size());

		      // add elements to the array list
		      al.add("C");
		      al.add("A");
		      al.add("E");
		      al.add("B");
		      al.add("D");
		      al.add("F");
		      al.add(1, "A2");
		      System.out.println("Size of al after additions: " + al.size());

		      // display the array list
		      System.out.println("Contents of al: " + al);
		      // Remove elements from the array list
		      al.remove("F");
		      al.remove(2);
		      System.out.println("Size of al after deletions: " + al.size());
		      System.out.println("Contents of al: " + al);
		      
		  	Fruit[] fruits = new Fruit[4];
		  	 
			Fruit pineappale = new Fruit("Pineapple", "Pineapple description",70); 
			Fruit apple = new Fruit("Apple", "Apple description",100); 
			Fruit orange = new Fruit("Orange", "Orange description",80); 
			Fruit banana = new Fruit("Banana", "Banana description",90); 
	 
			fruits[0]=pineappale;
			fruits[1]=apple;
			fruits[2]=orange;
			fruits[3]=banana;
	 
			Arrays.sort(fruits);
	 
			int i=0;
			for(Fruit temp: fruits){
			   System.out.println("fruits " + ++i + " : " + temp.getFruitName() + 
				", Quantity : " + temp.getQuantity());
			}
		
	*/		
			
	        /*Create and Initialize array of Object  */
	        for(int i1=0; i1< TestingDataSize; i1++)
	        {	
	        	TestingData2[i1]= new ArrayBuff();
	        }
	         
	        for(int i1=0; i1<TrainingDataSize; i1++)
	        {	
	        	TrainingData2[i1]= new ArrayBuff();
	        }
	        
	        for(int i1=0; i1<K; i1++)
	        {	
	        	Kneighbours[i1]= new Neighbour();
	        }
	        
	        for(int t=0; t<TrainingData2.length; t++)
	        for(int m=0; m<K; m++)
	        		
	        {	
	        	Kneighbours2[t][m]= new Neighbour();
	        }

	        

			
		        TrainMethod();
				TestMethod();
				knnMethod();
				
			      
		     		      
		   }//end of main
	
	

		public static void TrainMethod(){

			   /* store training data */
			   TrainingData2[0].setRecord(0, 3, 3, 0, "Happy ");
				TrainingData2[1].setRecord(1, -1, -4, 0, "Sad ");
				TrainingData2[2].setRecord(2, 2, 3, 0, "Happy ");
				TrainingData2[3].setRecord(3, 0, -5, 0, "Sad ");
				
				return;
			}	    
	

			public static	void TestMethod(){
				
				/* store testing data*/
				TestingData2[0].setRecord(0, 3, 4, 0, "Unknown ");
				TestingData2[1].setRecord(1,3, 3, 0, "Unknown ");
				
					return;
				
				
			}
			
			private static void knnMethod() {
				// TODO Auto-generated method stub
				double distance=0;
				Neighbour [] record_Kneighbours = new Neighbour [K];
				Neighbour [][] record_Kneighbours2 = new Neighbour [TrainingData2.length][K];	
				
				/*show databases */
				System.out.println("TestingData database");
				for(int i=0; i<TestingData2.length; i++){ 
					System.out.println("id: " + TestingData2[i].id + "\t" + "x:"+ TestingData2[i].x +
							"\t" +    "y:" + TestingData2[i].y +  "\t" + "z:" + TestingData2[i].z + "\t" + "activity: "+ TestingData2[i].label);
				}
				System.out.println("\n");
				System.out.println("\n");
				 
				for(int j=0; j<TrainingData2.length; j++){
					System.out.println("id: " + TrainingData2[j].id + "\t" + "x:"+ TrainingData2[j].x +
							"\t" + "y:" + TrainingData2[j].y + "\t" + "z:" + TrainingData2[j].z + "\t" +"activity:"+ TrainingData2[j].label);
			
				}
				
				System.out.println( "\n\n");
				
				
				/* set initial value for max_distance in knn neighbour*/
				//Neighbour.setMaxDistance(1000);
				
				/* for each record find K nearest neighbours */
				for(int i=0; i<TestingData2.length; i++){
					//for(int i=0; i<1; i++){
					Neighbour.setMaxDistance(1000);
					System.out.println("Record #:"+ i);
					for(int j=0; j<TrainingData2.length; j++){
						
						
							
						/*Get Distance */
						/*distance = EuclideanDistance(TrainingData2[i].getX(),TrainingData2[i].getY(),0, 
								          TestingData2[i].getX(), TestingData2[i].getY(), 0);		
						*/
						distance = EuclideanDistance(TrainingData2[j].getX(),TrainingData2[j].getY(),TrainingData2[j].getZ(), 
						          TestingData2[i].getX(), TestingData2[i].getY(), TestingData2[i].getZ());		
				
			
						System.out.println("Eucludean Distance:" + distance );
						
				     	/* sort */
						System.out.println("MaxDistance:" +Neighbour.getMaxDistance() ); 
						if(distance < Neighbour.getMaxDistance()){ //sort only if distance is smaller than max
							//Arrays.sort(Kneighbours);
							//record_Kneighbours=BubbleSort(distance,TestingData2[i].getActivity(),Kneighbours );
							record_Kneighbours=BubbleSort(distance,TrainingData2[j].getActivity(),Kneighbours );
							
						}
						
											
					}
					System.out.println("~~~Final Result for given record ~~~");
					
					for(int j=0; j<Kneighbours.length; j++){
						System.out.println("distance: " + Kneighbours[j].getDistance() + "\t" + "activity:"+ Kneighbours[j].getActivity());
				        
					}
					
					System.out.println("~~~BubbleSort return array ~~~");
					
					for(int j=0; j<record_Kneighbours.length; j++){
						System.out.println("distance: " + record_Kneighbours[j].getDistance() + "\t" + "activity:"+ record_Kneighbours[j].getActivity());
				        
					}
					
					
					
					
					System.out.println( "--------------------------------------------------\n");
					
					
					
				}
				
				
			}   
		    
			/*Sort array of K Objects by rank order */
			   private static Neighbour[] BubbleSort(double new_distance, String new_activity,  Neighbour [] KNN_array) {
				// TODO Auto-generated method stub
				Neighbour [] temp = new Neighbour [KNN_array.length+1];
				Neighbour [] temp2 = new Neighbour [KNN_array.length+1];
				
				/*Create and Initialize array of Object  */
		        for(int i1=0; i1< temp.length; i1++)
		        {	
		        	temp[i1]= new Neighbour();
		        	temp2[i1]= new Neighbour();
		        }
		    /*	System.out.println("temp values");
		    	System.out.println("temp length: "+ temp.length);
		    	System.out.println("temp[1]:distance " + temp[3].getActivity());
		    	*/
		    	
		        System.out.println("~~~Initial temp ~~~");
		        for(int j=0; j<temp.length; j++){
					System.out.println("distance: " + temp[j].getDistance() + "\t" + "activity:"+ temp[j].getActivity());
			        
				} 
		        
		        System.out.println("~~~Initial Kneighbours ~~~");
		        for(int j=0; j<Kneighbours.length; j++){
					System.out.println("distance: " + Kneighbours[j].getDistance() + "\t" + "activity:"+ Kneighbours[j].getActivity());
			        
				}
		        
		        
				System.arraycopy(KNN_array, 0, temp, 0, KNN_array.length);
				
				System.out.println("~~~ temp after copy ~~~");
		        for(int j=0; j<temp.length; j++){
					System.out.println("distance: " + temp[j].getDistance() + "\t" + "activity:"+ temp[j].getActivity());
			        
				} 
		        
				
				
				/* append new data to the end array to be sorted*/
				temp[KNN_array.length].setActivity(new_activity);
				temp[KNN_array.length].setDistance(new_distance);
		    
				System.out.println("~~~ temp after append ~~~");
		        for(int j=0; j<temp.length; j++){
					System.out.println("distance: " + temp[j].getDistance() + "\t" + "activity:"+ temp[j].getActivity());
			        
				} 
		        
					
				Arrays.sort(temp); // this goes bad
				
				
				System.out.println("~~~ temp after sort ~~~");
		        for(int j=0; j<temp.length; j++){
					System.out.println("distance: " + temp[j].getDistance() + "\t" + "activity:"+ temp[j].getActivity());
			        
				} 
			/*	System.out.println("distance: " + temp[0].getDistance() + "\t" + "activity:"+ temp[0].getActivity());
				System.out.println("distance: " + temp[1].getDistance() + "\t" + "activity:"+ temp[1].getActivity());
				System.out.println("distance: " + temp[2].getDistance() + "\t" + "activity:"+ temp[2].getActivity());
				System.out.println("distance: " + temp[3].getDistance() + "\t" + "activity:"+ temp[3].getActivity());
				*/
				
				System.arraycopy(temp, 0, KNN_array, 0, KNN_array.length);
				/*System.out.println("~~~~~~~~~~~~~~~~~~~~\n" );
				System.out.println(KNN_array[0].getDistance());
				System.out.println(KNN_array[1].getDistance());
				System.out.println(KNN_array[2].getDistance());
				Neighbour.setMaxDistance(KNN_array[KNN_array.length-1].getDistance()); //get distance of last element
				*/
				Neighbour.setMaxDistance(KNN_array[KNN_array.length-1].getDistance()); //get distance of last element
				
				//Neighbour.setMaxDistance(5); //get distance of last element
				
				//System.out.println("~~~~~~~~~~~~~~~~~~~~\n" );
				
				System.out.println("~~~ Knearbours final ~~~");
		        for(int j=0; j<Kneighbours.length; j++){
					System.out.println("distance: " + Kneighbours[j].getDistance() + "\t" + "activity:"+ Kneighbours[j].getActivity());
			        //System.out.println("maxvalue:" + Neighbour.getMaxDistance());
			        //System.out.println("maxvalue:" + KNN_array[KNN_array.length-1].getMaxDistance());
			        
				}
		        
		        System.out.println("maxvalue:" + KNN_array[KNN_array.length-1].getMaxDistance());
		        
				
				return KNN_array;
				   
				
			}





			   

			private static double EuclideanDistance(float trainingDataX, float trainingDataY,
						float trainingDataZ, float testDataX, float testDataY,
						float testDataZ) {
					// TODO Auto-generated method stub
			    	  return Math.sqrt(Math.pow((trainingDataX-testDataX),2) + Math.pow((trainingDataY-testDataY),2) + Math.pow((trainingDataZ-testDataZ),2));
					
				}
		    

	
	
}



