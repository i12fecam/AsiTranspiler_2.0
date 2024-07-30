# Microinstrucciones de SICOME

 Las microinstrucciones se agrupan en diferentes grupos dependiendo que a que zona de la computadora afecten:

## MAR
- PC->MAR
- GPR{AD}->MAR
- SP->MAR
## OPR
- GPR->M
- QR->M
- GPR{OP}->OPR

## PC, SP, SC
- PC+1->PC
- GPR->PC
- SP+1->SP
- SP-1->SP
- LOAD_SC
- SC-1->SC

## GPR
- M->GPR
- ACC->GPR
- PC->GPR
- GPR+1->GPR
- QR->GPR
- !GPR->GPR
- !GPR+1->GPR

## ALU
- 0->ACC
- !ACC->ACC
- ACC+1->ACC
- !ACC+1->ACC
- GPR+ACC->ACC
- ROL_F_ACC
- ROR_F_ACC
- 0->QR
- 1->OVF
- 0->OVF
- 0->Qn+1
- !QR+1->QR
- GPR->QR
- M->QR
- 1->Qn
- X->Qs
- ASHR_ACC_QR
- ROL_F_ACC_QR
- ROR_F_ACC_QR
- SHL_F_A_Q
- SHR_F_ACC_QR
- 0->F
- !F->F
- !GPR+1+ACC->ACC
- !ACCQR+1->ACCQR
- 0->N
- 1->N
- !A+1->A
- !As->As
- 0->As
- As->Qs
- Qs@Bs->As
- Qs@Bs->Qs
- Q+1->Q
- 0->A
- A+B->EA
- A+!B+1->EA
- A+!B+1->A
- E->OVF