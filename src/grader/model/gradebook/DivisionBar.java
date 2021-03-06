package grader.model.gradebook;

/**
 * Contains the lower and upper-bound percentages, the letter grade
 *  it is associated with, and the color that this range will be
 *  associated with.
 */
public abstract class DivisionBar
{
    /**
     * Contains the lower-bound for this range.
     */ 
    public Percentage low;
    /**
     * The letter grade associated with this range.
     */ 
    public LetterGrade letterGrade;

    /**
     * The color to modify the visuals of this range to.
     */
    public Color color;  
}
