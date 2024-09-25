class closestneighbours {
	public static void main(String[] args) {
		int[] numbers = {0, 5, 1209, 6, 2, 111, 112, 33};


	for (int i = 0; i < numbers.length; i++){
		int diferença = Math.abs(numbers[i]-numbers[i++]); 
	
		System.out.println("Os dois números com menor diferença são: "+ diferença);
	}

	}
}
