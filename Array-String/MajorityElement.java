public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int majorityElement = findMajorityElement(nums);
        System.out.println("The majority element is: " + majorityElement);
    }

    public static int findMajorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        // Fase 1: Encontrar el candidato
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Fase 2: Verificar que el candidato es realmente el mayoritario
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        // Dado que se asume que siempre existe un elemento mayoritario,
        // no es necesario verificar explícitamente si count > n/2
        return candidate;
    }
}


//Given an array nums of size n, return the majority element.

//The majority element is the element that appears more than ⌊n / 2⌋ times. 
//You may assume that the majority element always exists in the array.