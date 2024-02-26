package internals;

public enum MicroInstruction {
    //Mar
    pc_to_mar("PC->MAR","PC->MAR"),
    gpr_ad_to_mar("GPR(AD)->MAR","GPR(AD)->MAR"),//No sale en cableado
    sp_to_mar("SP->MAR","SP->MAR"),
    //OPR
    gpr_to_m("GPR->MAR","GPR->MAR"),
    gpr_op_to_opr("GPR(OP)->OPR","GPR(OP)->OPR"),
    //PC,SP,SC
    pc_plus_to_pc("PC+1->PC","PC+1->PC"),
    gpr_to_pc("GPR->PC","GPR->PC"),
    sp_plus_to_pc("SP+1->SP","SP+1->SP"),
    sp_minus_to_pc("SP-1->SP","SP-1->SP"),
    load_sc("LOAD_SC","LOAD_SC"),//TODO esto de que va
    sc_minus_to_sc("SC-1->SC","SC-1->SC"),
    //GPR
    m_to_gpr("M->GPR","M->GPR"),
    acc_to_gpr("ACC->GPR","ACC->GPR"),
    pc_to_gpr("PC->GPR","PC->GPR"),
    gpr_plus_to_gpr("GPR+1->GPR","GPR+1->GPR"),
    qr_to_gpr("QR->GPR","QR->GPR"),
    neg_gpr_to_gpr("!GPR->GPR","GPR'->GPR"),
    neg_gpr_plus_to_gpr("!GPR+1->GPR","GPR'+1->GPR"),
    //ALU
    zero_to_acc("0->ACC","0->ACC"),
    neg_acc_to_acc("!ACC->ACC","!ACC->ACC"),
    acc_plus_to_acc("ACC+1->ACC","ACC+1->ACC"),
    neg_acc_plus_to_acc("!ACC+1->ACC","ACC'+1->ACC"),
    gpr_plus_acc_to_acc("GPR+ACC->ACC","GPR+ACC->GPR"),
    rol_f_acc("ROL_F_ACC","ROL_F_ACC"),
    ror_f_acc("ROR_F_ACC","ROR_F_ACC"),
    zero_to_qr("0->QR","0->QR"),
    one_to_ovf("1->OVF","1->OVF"),
    zero_to_ovf("0->OVF","0->OVF"),
    zero_to_qn_plus("0->Qn+1","0->Qn+1"),
    neg_qr_plus_to_qr("!QR+1->QR","QR'+1->QR"),
    gpr_to_qr("GPR->QR","GPR->QR"),
    m_to_qr("M->QR","M->QR"),
    one_to_qn("1->Qn","1->Qn"),
    x_to_qs("X->Qs","X->Qs"),
    ashr_acc_qr("ASHR_ACC_QR","ASHR_ACC_QR"),
    rol_f_acc_qr("ROL_F_ACC_QR","ROL_F_ACC_QR"),
    ror_f_acc_qr("ROR_F_ACC_QR","ROR_F-ACC_QR"),
    shl_f_a_q("SHL_F_A_Q","SHL_F_A_Q"),
    zero_to_f("0->F","0->F"),
    neg_f_to_f("!F->F","F'->F"),
    neg_gpr_plus_one_plus_acc_to_acc("!GPR+1+ACC->ACC","GPR'+1+ACC->ACC"),
    neg_accqr_plus_to_accqr("!ACCQR+1->ACCQR","ACCQR'+1->ACCQR"),
    zero_to_n("0->N","0->N"),
    one_to_n("1->N","1->N"),
    neg_a_plus_to_a("!A+1->A","!A+1->A"),
    neg_as_to_as("!As->As","As'->As"),
    zero_to_as("0->As","0->As"),
    as_to_qs("As->Qs","As->Qs"),
    qs_xor_bs_to_as("Qs@Bs->As","Qs@Bs->As"),
    qs_xor_bs_to_qs("Qs@Bs->Qs","Qs@Bs->Qs"),
    neg_q_plus_to_q("Q+1->Q","Q'+1->Q"),
    zero_to_a("0->A","0->A"),
    a_plus_b_to_ea("A+B->EA","A+B->EA"),
    a_plus_neg_b_plus_one_to_ea("A+!B+1->EA","A+!B+1->EA"),
    a_plus_neg_b_plus_one_to_a("A+!B+1->A","A+B'+1->A"),
    e_to_ovf("E->OVF","E->OVF");

    public final String inputName;

    public final String outputName;

    private MicroInstruction(String inputName, String outputName){
        this.inputName = inputName;
        this.outputName = outputName;
    }

    public static MicroInstruction valueOfInput(String input){
        for(MicroInstruction mi : values()){
            if(mi.inputName.equals(input)){
                return mi;
            }
        }
        return null;
    }

    public static MicroInstruction valueOfOutput(String output){
        for(MicroInstruction mi : values()){
            if(mi.outputName.equals(output)){
                return mi;
            }
        }
        return null;
    }
    public MicroInstructionType getType(){
        if( ordinal()<= 2){
             return MicroInstructionType.mar;
        } else if (ordinal() <= 4) {
             return MicroInstructionType.opr;
        } else if (ordinal() <= 10) {
            return MicroInstructionType.pc_sp_sc;
        } else if (ordinal() <= 17) {
            return MicroInstructionType.gpr;
        }
        else{
            return MicroInstructionType.alu;
        }
    }

}
